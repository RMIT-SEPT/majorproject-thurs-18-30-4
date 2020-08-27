import React, { Component } from 'react'
import Person from './Persons/Person'
import "bootstrap/dist/css/bootstrap.min.css"



 class Dashboard extends Component {
    render() {
        return (
            <div>
                <Person/>   
            </div>
        )
    }
}
export default Dashboard;