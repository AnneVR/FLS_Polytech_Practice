export interface LoginSuccessAnswer {
    username: string;
    token: string;
}

export interface LoginFailureAnswer {
    message: string;
}