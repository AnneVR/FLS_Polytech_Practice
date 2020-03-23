import * as React from "react";
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../../actions";

import "./NavBar.css"
import { StateTyping, LoginStatus } from "../../reducers";

export function NavBar() {
    const dispatch = useDispatch();
    const isAuth = useSelector<StateTyping, boolean>((state) => state.authInfo.status == LoginStatus.LOADED)

    return (
        isAuth && 
        <div className="navbar">
            <span className="navbar__logout"
                onClick={() => dispatch(logout())}>
                Выйти
            </span>
        </div>
    );
}