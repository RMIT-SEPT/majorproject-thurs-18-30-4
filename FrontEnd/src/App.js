import React from "react";
import "./App.css";
import { BrowserRouter as Router} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Main from "./components/Main/Main";
import {Provider} from "react-redux";
import store from "./store";


function App() {
  return (
    <Provider store={store}>
    <Router>
      <div>
        <Main />
      </div>
    </Router>
    </Provider>
  );
}

export default App;
