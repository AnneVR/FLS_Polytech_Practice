import * as React from "react";

import { Switch, Route } from "react-router-dom";
import { Login } from "./components/Login/Login";
import { NavBar } from "./components/NavBar/NavBar";

export function Routes() {
    return (
        <>
        <NavBar/>
        <Switch>
            <Route exact path="/login" component={Login}/>
        </Switch>
        </>
    )
}