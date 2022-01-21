package com.chovietz.config;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.chovietz.service.JwtUserDetailsService;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtUtils jwtUtil;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
    	try {
    		String jwt = parseJwt(request);
    		if(jwt != null && jwtUtil.validateJwt(jwt)) {
    			String username = jwtUtil.getUsernameFromJwt(jwt);
    			
    			UserDetails userdetails = jwtUserDetailsService.loadUserByUsername(username);
    			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
    			auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    			
    			SecurityContextHolder.getContext().setAuthentication(auth);
    		}
    	} catch (Exception e) {
    		log.error("Cannot set user authentication: {}", e);
    	}
    	
    	chain.doFilter(request, response);
    }
    
    private String parseJwt(HttpServletRequest request) {
    	String headerAuth = request.getHeader("Authorization");
    	
    	if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
    		return headerAuth.substring(7, headerAuth.length());
    	}
    	return null;
    };

}