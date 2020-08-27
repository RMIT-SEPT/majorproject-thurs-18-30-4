import React, { Component } from 'react';


class SignUp extends Component {
    render() {
        return (
            <div>
            <div className="alert alert-secondary">signup</div>
            <form>
                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email"></input>
                </div>
                <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Enter password"></input>
            </div>
            </form>
     
         
            </div>
        )
    }
}
export default SignUp;