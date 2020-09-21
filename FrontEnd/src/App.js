import React from "react";
import "./App.css";
import { BrowserRouter as Router} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Layout/Header"; 
import {Provider} from "react-redux";
import store from "./store";


function App() {
  return (
    <Provider store={store}>
  
    <div>
     <Header/>
      </div>
    
    </Provider>
  );
}

export default App;
