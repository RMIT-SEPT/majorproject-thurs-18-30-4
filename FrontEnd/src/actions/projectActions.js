import axios from "axios";
import AuthenticationService from "../services/AuthenticationService";
import {
    GET_ERRORS,
    USERS_ERROR,
    SET_MESSAGE,
    CLEAR_MESSAGE,
    SIGNUP_SUCCESS,
    SIGNUP_FAIL,
    SIGNIN_SUCCESS,
    SIGNIN_FAIL,
    SIGNOUT_SUCCESS,
    SIGNOUT_FAIL
  } from "./types";

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
/**
 * Sign up action for the authentication with dispatch
 * Signup with username, email, password, name and role fields
 * If successful, dispatch SIGNUP_SUCCESS and SET_MESSAGE 
 * If error, dispatch SIGNUP_FAIL and SET_MESSAGE
 **/
export const signup = (username, email, password, name, role) => (dispatch) => {
    return AuthenticationService.signup(username, email, password, name, role).then(
      (response) => {
        dispatch({
          type: SIGNUP_SUCCESS
        });
        dispatch({
          type: SET_MESSAGE,
          payload: response.data.message
        });
        return Promise.resolve();
      },

      (err) => {
        dispatch({
          type: SIGNUP_FAIL
        });

        const errMessage = (err.response && err.response.data && err.response.data.message) 
        || err.message || err.toString();

        dispatch({
          type: SET_MESSAGE,
          payload: errMessage
        });
        return Promise.reject();
      }
    );
};

/**
 * Sign in action for the authentication with dispatch
 * Sign in with username and password fields
 * If successful, dispatch SIGNIN_SUCCESS
 * If error, dispatch SIGNIN_FAIL and SET_MESSAGE
 **/
export const signin = (username, password) => (dispatch) => {
    return AuthenticationService.signin(username, password).then(
      (data) => {
        dispatch({
          type: SIGNIN_SUCCESS,
          payload: { user: data }
        });
        return Promise.resolve();
      },

      (err) => {
        dispatch({
          type: SIGNIN_FAIL
        });

        const errMessage = (err.response && err.response.data && err.response.data.message) 
        || err.message || err.toString();

        dispatch({
          type: SET_MESSAGE,
          payload: errMessage
        });
        return Promise.reject();
      }
    );
};

/**
 * Sign out action for the authentication with dispatch
 * If successful, dispatch SIGNOUT_SUCCESS and SET_MESSAGE 
 * If error, dispatch SIGNOUT_FAIL and SET_MESSAGE
 **/
export const signout = () => (dispatch) => {
    return AuthenticationService.signout().then(
        (response) => {
            dispatch({
                type: SIGNOUT_SUCCESS
            });
            dispatch({
                type: SET_MESSAGE,
                payload: response.data.message
            });
            return Promise.resolve();
        },
        (err) => {
            dispatch({
                type: SIGNOUT_FAIL
            });

            const errMessage = (err.response && err.response.data && err.response.data.message) 
            || err.message || err.toString();

            dispatch({
                type: SET_MESSAGE,
                payload: errMessage
            });
            return Promise.reject();
        }
    );
};

//action to set message
export const setMessage = (message) => ({
    type: SET_MESSAGE,
    payload: message
});

//action to clear message
export const clearMessage = () => ({
    type: CLEAR_MESSAGE
});