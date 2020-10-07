import {combineReducers} from "redux";
import authenticationReducer from "./authenticationReducer";
import messageReducer from "./messageReducer";
import errorReducer from "./errorReducer";

//Since only a single store will be used in our application
//it is ideal to use a combine reducer to organize data
export default combineReducers({
    authenticationReducer,
    messageReducer,
    errorReducer
});