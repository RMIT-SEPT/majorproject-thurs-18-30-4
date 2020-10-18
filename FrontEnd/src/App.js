import React, { Component } from 'react'; 
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Layout/Header"; 
import {Provider} from "react-redux";
import store from "./store";
class App extends Component {
  

  render(){
    return (
      <Provider store={store}>
      <div>
      <Header/>
      </div>  
      </Provider> 


    );
  }
}

export default App;
