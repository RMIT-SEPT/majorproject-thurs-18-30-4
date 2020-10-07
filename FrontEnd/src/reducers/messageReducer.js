//Reducers specify how the application's state changes in response to actions sent to the store. 
import {
    SET_MESSAGE, 
    CLEAR_MESSAGE
} from "../actions/types";

const previousState = {};
//The reducer is a pure function that takes the previous state and an action, and returns the next state.
export default function (state = previousState, action) {
  const { 
      type, 
      payload 
    } = action;

  switch (type) {
    case SET_MESSAGE:
      return { 
        message: payload 
    };

    case CLEAR_MESSAGE:
      return { 
        message: "" 
    };
    //We return the previous state in the default case. 
    //It's important to return the previous state for any unknown action.
    default:
      return state;
  }
}
