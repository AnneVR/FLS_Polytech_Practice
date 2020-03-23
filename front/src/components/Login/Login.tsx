import * as React from "react";
import "./Login.css";
import { useDispatch, useSelector } from "react-redux";
import { loginAttempt } from "../../actions";
import { useState, useMemo } from "react";
import { StateTyping, LoginStatus } from "../../reducers";

export function Login() {
    const dispatch = useDispatch();
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    const handleLoginInput = useMemo(
        () => (event: React.FormEvent<HTMLInputElement>) => setLogin(event.currentTarget.value),
        []
    );

    const handlePasswordInput = useMemo(
        () => (event: React.FormEvent<HTMLInputElement>) => setPassword(event.currentTarget.value),
        []
    );

    const error = useSelector<StateTyping>((state) => {
        if (state.authInfo.status == LoginStatus.FAILURE) {
            return state.authInfo.error
        }
        return null;
    })
    const currState = useSelector<StateTyping, LoginStatus>((state) => {
        return state.authInfo.status;
    });

    return (
        <div className="login">
            {
                error && <div className="login__error">
                    {error}
                </div>
            }
            <div className="login__input">
                <input placeholder="Логин"
                    value={login}
                    onChange={handleLoginInput}
                    className="login__login-input" />
            </div>
            <div className="login__input">
                <input
                    type="password"
                    value={password}
                    placeholder="Пароль"
                    onChange={handlePasswordInput}
                    className="login__password-input"
                />
            </div>
            <div className="login__input">
                <button
                    onClick={() => {
                        if (currState != LoginStatus.LOADING)
                            dispatch(loginAttempt(login, password));
                    }}
                    className="login__confirm"
                >
                    Войти в систему
                </button>
            </div>
        </div>
    );
}
