import axios from "axios";
//Url of the Authentication API
const URL_API = "http://localhost:8080/api/auth/";

class AuthenticationService{
    //login with username and password field and save to local storage with JWT
    signin(username, password) {
        return axios
        //send POST request with username and password
        .post(URL_API + "signin", {username, password})
        .then((response) => {
            if(response.data.accessToken){
                localStorage.setItem("user",JSON.stringify(response.data));
            }
            return response.data;
        });
    }
    //remove user JWT from local storage
    signout() {
        localStorage.removeItem("user");
    }
    //sign up with username, email, password, name and role field
    signup(username, email, password, name, role) {
    //send POST request with username, email, password, name and role to the URL API
    return axios.post(URL_API + "signup", {
        username,
        email,
        password,
        name,
        role
    });
    }
}
export default new AuthenticationService();
