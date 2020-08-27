import React, { Component } from 'react';

class Header extends Component {
    render() {
        return (
            <div>
                <nav className ="navbar navbar-dark bg-dark">
                    <div className= "container">
                        <a className= "navbar-brand" href= "Dashboard.html">
                        <h1>agme.</h1>
                        </a>

                       <a className= "navbar-brand" href= "Login.html">login</a>
                    </div>
                </nav>


            </div>
        )
    }
}
export default Header;
