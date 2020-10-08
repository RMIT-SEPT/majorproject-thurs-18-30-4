//extensions like thunk, redux, redux devtool extension are required
import {createStore, applyMiddleware, compose} from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";
import { composeWithDevTools } from "redux-devtools-extension";

//The redux store will feature actions and reducer together
const initialState = {};
const middleware = [thunk];

/*
let store;

if (window.navigator.userAgent.includes("Chrome")){
    store = createStore(
        rootReducer,
        initialState,
        compose(
            applyMiddleware(...middleware)
        )
    );
} else {
    store = createStore(
        rootReducer,
        initialState,
        compose(
            applyMiddleware(...middleware))
    );
}
*/
//pass the combineReducers() we created in /reducers/index.js to createStore();
//apply it with the extensions we imported
const store = createStore(rootReducer,composeWithDevTools(applyMiddleware(...middleware)));
export default store;