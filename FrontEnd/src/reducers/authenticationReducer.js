import {
    SIGNUP_SUCCESS,
    SIGNUP_FAIL,
    SIGNIN_SUCCESS,
    SIGNIN_FAIL,
    SIGNOUT_SUCCESS,
    SIGNOUT_FAIL
  } from "../actions/types";
  
  const user = JSON.parse(localStorage.getItem("user"));
  
  const initialState = user ? { isSignedIn: true, user } : { isSignedIn: false, user: null };
  
  //set the isSignIn and user state
  export default function (state = initialState, action) {
    const { type, payload } = action;
  
    switch (type) {
    //if sign up is successful, isSignedIn is false
      case SIGNUP_SUCCESS:
        return {
          ...state,
          isSignedIn: false
        };
    //if sign up is unsuccessful, isSigneIn is false
      case SIGNUP_FAIL:
        return {
          ...state,
          isSignedIn: false
        };
    //if sign in is successful, isSignedIn is true & user not null
      case SIGNIN_SUCCESS:
        return {
          ...state,
          isSignedIn: true,
          user: payload.user
        };
    //if sign in is unsuccessful, isSignedIn is false & user null
      case SIGNIN_FAIL:
        return {
          ...state,
          isSignedIn: false,
          user: null
        };
    //if sign out is successful, isSignedIn is false & user null
      case SIGNOUT_SUCCESS:
        return {
          ...state,
          isSignedIn: false,
          user: null
        };
    //if signout is unsuccessful, isSignedIn is true & user not null
      case SIGNOUT_FAIL:
        return {
          ...state,
          isSignedIn: true,
          user: payload.user
        };
      default:
        return state;
    }
  }
  