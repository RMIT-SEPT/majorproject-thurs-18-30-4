import axios from "axios";
import {GET_ERRORS} from "./types";

export const person = (person,history) => async dispatch => {
    try{
    const res = await axios.post("http://localhost:8080/api/auth/signup", person);
    history.push("/FrontEnd/src/components/Dashboard");
    } catch (err){
        dispatch({
            type: GET_ERRORS,
            payload: err.response.data
        });
    }

};