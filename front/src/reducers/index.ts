import { produce } from "immer";

import { combineReducers, createStore, applyMiddleware, compose } from "redux";
import { connectRouter, routerMiddleware } from "connected-react-router";
import { createBrowserHistory } from "history";
import { LOGIN_ATTEMPT, LOGIN_FAILURE, LOGIN_SUCCESS, Actions, LOGOUT } from "../actions";
import { createEpicMiddleware } from "redux-observable";
import { rootEpic } from "../epics";

export enum LoginStatus {
    NOT_LOADED = "NOT_LOADED",
    LOADING = "LOADING",
    LOADED = "LOADED",
    FAILURE = "FAILURE"
}

export interface AuthStateWAITING {
    status: LoginStatus.LOADING | LoginStatus.NOT_LOADED
}

export interface AuthStateFAILURE {
    status: LoginStatus.FAILURE,
    error: string
}

export interface AuthStateDONE {
    status: LoginStatus.LOADED,
    name: string
}

export const defaultAuthState: AuthStateWAITING = {
    status : LoginStatus.NOT_LOADED
}

export type AuthState = AuthStateWAITING | AuthStateDONE | AuthStateFAILURE; 

export interface StateTyping {
    authInfo: AuthState,
}

export const authReducer = (
    state: AuthState = defaultAuthState,
    action: Actions
) => {
    switch (action.type) {
        case LOGIN_ATTEMPT:
            return produce(state, draft => {
                draft.status = LoginStatus.LOADING;
            });
        case LOGIN_FAILURE:
            return produce(state, draft => {
                draft.status = LoginStatus.FAILURE;
                (draft as AuthStateFAILURE).error = action.message;
            });
        case LOGIN_SUCCESS:
            return produce(state, draft => {
                draft.status = LoginStatus.LOADED;
                (draft as AuthStateDONE).name = action.username;
            });
        case LOGOUT:
            return produce(state, () => {
                return defaultAuthState;
            });
        default:
            return state;
    }
};

export const rootState = history =>
    combineReducers({
        authInfo: authReducer,
        router: connectRouter(history)
    });

export const history = createBrowserHistory();

const epicMiddleware = createEpicMiddleware<
    Actions,
    Actions,
    StateTyping
>();

const composeEnhancers =
    (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export function configureStore() {
    const store = createStore(
        rootState(history),
        composeEnhancers(
            applyMiddleware(epicMiddleware, routerMiddleware(history))
        )
    );

    epicMiddleware.run(rootEpic);

    return store;
}
