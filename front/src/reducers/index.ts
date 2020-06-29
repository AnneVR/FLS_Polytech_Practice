import { produce } from "immer";

import { combineReducers, createStore, applyMiddleware, compose, Reducer } from "redux";
import { connectRouter, routerMiddleware, LOCATION_CHANGE } from "connected-react-router";
import { createBrowserHistory } from "history";
import { Actions } from "../actions";
import { createEpicMiddleware } from "redux-observable";
import { rootEpic } from "../epics";


type ReturnType<T> = T extends (...args: any[]) => infer R ? R : any;
type GetStateTyping<T> = T extends Reducer<infer U> ? U : any; 

export const rootState = history =>
    combineReducers({
        router: connectRouter(history),
    });

export type returnedReducer = ReturnType<typeof rootState>
export type StateTyping = GetStateTyping<returnedReducer>

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

    // epicMiddleware.run(rootEpic);

    return store;
}
