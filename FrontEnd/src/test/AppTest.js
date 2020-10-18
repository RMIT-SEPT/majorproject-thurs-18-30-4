import React from "react";
import ReactDOM from "react-dom";
import {act} from "react-dom/test-utils";
import { expect } from "chai";
import Dashboard from '../components/Dashboard/Dashboard';
import App from '../App';
import Person from '../components/Persons/Person';
import Main from "../components/Main/Main";
var jsdom = require("mocha=jsdom");

global.document = jdsom({
    url: "http://localhost:8080"
});

let rootContainer;

beforeEach(() => {
    rootContainer =  document.createElement("div");
    document.body.appendChild(rootContainer);
});

afterEach(() => {
    document.body.removeChild(rootContainer);
    rootContainer = null;
});

// Dashboard
describe("Dashboard  Component Testing", () =>{
    it('Dashboard renders without Crashing',() => {
        act(()=>{
            ReactDOM.render(<Dashboard/>, div);
        });
        const h1 = rootContainer.querySelector("h1");
        expect(h1.textContent).to.equal("My Dashboard");
    });
});

// Person Test
describe("Person  Component Testing", () =>{
    it('Pesrson renders without Crashing',() => {
        act(()=>{
            ReactDOM.render(<Person/>, div);
        });
        const h1 = rootContainer.querySelector("h1");
        expect(h1.textContent).to.equal("Hello");
    });
});

//Main Page Test 
describe("Main Component Testing", () =>{
    it('Main renders without Crashing',() => {
        act(()=>{
            ReactDOM.render(<Main/>, div);
        });
        const h1 = rootContainer.querySelector("h1");
        expect(h1.textContent).to.equal(" Main");
    });
});
//-----------------------------------------------------------------------------//

// App Test
describe("App Component Testing", () =>{
    it('App renders without Crashing',() => {
        act(()=>{
            ReactDOM.render(<App />, div);
            const header = rootContainer.querySelector("Header");
            expect(header.textContent).to.equal("");
        });
    });
});