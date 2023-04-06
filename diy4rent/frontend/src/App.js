import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Herramientas from './Herramientas';
import TFGEdit from "./TFGEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/usuarios' exact={true} component={HERRAMIENTAList}/>
            <Route path='/tfgs/:herramienta' component={GESTIONARHERRAMIENTA}/>
          </Switch>
        </Router>
    )
  }
}

export default App;