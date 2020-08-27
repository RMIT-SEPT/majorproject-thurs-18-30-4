import React from 'react';
import './App.css';
import Header from './components/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import Dashboard from './components/Dashboard';
import SignUp from './components/SignUp/SignUp';

function App() {
  return (
    <div>
      <Header/>
      <Dashboard/>
      <SignUp/>
    </div>
  );
}

export default App;
