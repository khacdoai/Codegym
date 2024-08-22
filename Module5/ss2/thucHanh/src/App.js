import logo from './logo.svg';
import React from 'react';

import './App.css';
import {Header} from "./components/Header";
import Student from "./components/Student";

function App() {
    return (
        // <React.Fragment>
        <>
            <Student />
            <h1>C07</h1>
            <Header id='myHeader' className='myClassH' dataHeader='HomePage'/>
            <hr/>
            <Header dataHeader='Content'/>
            <hr/>
            <Header dataHeader='Home'><button>ABC</button></Header>
        </>
        // </React.Fragment>
    );
}

export default App;
