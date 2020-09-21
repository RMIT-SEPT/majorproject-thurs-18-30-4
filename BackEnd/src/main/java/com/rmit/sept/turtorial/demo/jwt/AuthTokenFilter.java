package com.rmit.sept.turtorial.demo.jwt;

import com.rmit.sept.turtorial.demo.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthTokenFilter extends OncePerRequestFilter {

    //variable for jwt utilities
    @Autowired
    private JwtUtils jwtUtils;

    //variable for user details service implementation
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //to get the logging from the authentication token filer
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    //method for executing filter regarding the JWT
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            //validation on JWT  and user authentication
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                // start loading the username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //authentication for user begins
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            //display error at the logger
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    //method to parse the JWT
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        //header auth set to start with "bearer" due to its token type being bearer
        //Bearer Authentication
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }
}