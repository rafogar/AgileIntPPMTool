import React, { Component } from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Routes, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";

class App extends Component {
  render() {
    return (
      <Routes>
        <div className="App">
          <Header />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/addProject" component={AddProject} />
        </div>
      </Routes>
    );
  }
}

export default App;
