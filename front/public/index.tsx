import * as React from "react";
import * as ReactDOM from "react-dom";

import { ConnectedRouter } from "connected-react-router";
import { Provider } from "react-redux";

import { configureStore, history } from "../src/reducers/";
import { Routes } from "../src/router";

const store = configureStore();

export function App() {
    return (
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <Routes />
            </ConnectedRouter>
        </Provider>
    );
}

var mountNode = document.getElementById("app");
ReactDOM.render(<App />, mountNode);
