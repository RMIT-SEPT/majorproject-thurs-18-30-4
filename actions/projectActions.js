import axios from "axios";
import { GET_ERRORS } from "./types";

export const createPerson = {person, history} => async dispatch => {
    try {

        // change https://localhost according to the database 
        const res = await axios.post("http://localhost:8000/api/person", person);
        // change "/xxx" according to the page
        history.push("/dashboard");
    } catch (err) {
        dispatch(
            {
                type: GET_ERRORS,
                payload: err.response.data
            }
        );
    }
};