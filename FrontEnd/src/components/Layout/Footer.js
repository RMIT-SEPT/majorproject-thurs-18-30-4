import React, { Component } from 'react';
import './Footer.css';
import facebookLogo from './Images/facebook-24px.png';
import instagramLogo from './Images/instagram.png'
import twitterLogo from './Images/twitter.png';

console.log(facebookLogo, instagramLogo, twitterLogo);

 class Footer extends Component {
    render() {
        return <div className="Footer"> 2020 Copyright 
          
                <img src={facebookLogo} alt="Facebook Logo"/>;
   
      
                <img src= {instagramLogo} alt= "Instagram Logo"/>;
       
      
                <img src={twitterLogo} alt= "Twitter Logo"/>;
     
        </div>

    }
}
export default Footer;
