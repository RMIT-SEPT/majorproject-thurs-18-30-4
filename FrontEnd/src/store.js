import {createStore, applyMiddleware, compose} from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

const initialState = {};
const middleware = [thunk];

let store;

if (window.navigator.userAgent.includes("Chrome")) {
    stor = createStore (
        rootReducer,
        initialState,
        compose(
            applyMiddleware(...middleware),
            window.__REDUX_DEVTOOLS_EXTENTION__ &&
              window.__REDUX_DEVTOOLS_EXTENTION__()
        )
    );
} else {
    store = createStore(
        rootReducer,
        initialState,
        compose (applyMiddleware(...middleware))

        );
}

export default store;
