import * as React from "react";

import { Switch } from "react-router-dom";
import { HomePage } from "./components/HomePage/HomePage";

export function Routes() {
    return (
        <>
        <Switch>
            <HomePage />
        </Switch>
        </>
    )
}
