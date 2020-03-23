import { RouterAction } from "connected-react-router";

export const LOGIN_ATTEMPT = "LOGIN_ATTEMPT";
export type LOGIN_ATTEMPT = typeof LOGIN_ATTEMPT;

export interface LoginAttemptAction {
    type: LOGIN_ATTEMPT;
    username: string;
    password: string;
}

export const loginAttempt = (
    username: string,
    password: string
): LoginAttemptAction => ({
    type: LOGIN_ATTEMPT,
    username,
    password
});

export const LOGIN_SUCCESS = "LOGIN_SUCCESS";
export type LOGIN_SUCCESS = typeof LOGIN_SUCCESS;

export interface LoginSuccessAction {
    type: LOGIN_SUCCESS;
    username: string;
}

export const loginSuccess = (username: string): LoginSuccessAction => ({
    type: LOGIN_SUCCESS,
    username
});

export const LOGIN_FAILURE = "LOGIN_FAILURE";
export type LOGIN_FAILURE = typeof LOGIN_FAILURE;

export interface LoginFailureAction {
    type: LOGIN_FAILURE;
    message: string;
}

export const loginFailure = (message: string): LoginFailureAction => ({
    type: LOGIN_FAILURE,
    message
});

export const LOGOUT = "LOGOUT";
export type LOGOUT = typeof LOGOUT;

export interface LogoutAction {
    type: LOGOUT;
}

export const logout = (): LogoutAction => ({
    type: LOGOUT,
});

export type Actions =
    | RouterAction
    | LoginAttemptAction
    | LoginSuccessAction
    | LoginFailureAction
    | LogoutAction;
