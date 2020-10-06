//for grantng permission to respective roles
export default function headerService(){
    //get "user" item from local storage
    const user = JSON.parse(localStorage.getItem('user'));

    if (user && user.accessToken){
        return {
            //Header KEY = AGME Authorizatioon and Value = Bearer <accesstoken>

            //Bearer authentication (also called token authentication) is an HTTP authentication scheme 
            //that involves security tokens called bearer tokens.
            AGME_Authorization: 'Bearer ' + user.accessToken};
    } else{
        return {};
    }
}