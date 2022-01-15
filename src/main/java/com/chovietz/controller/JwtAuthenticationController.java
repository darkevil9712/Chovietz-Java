package com.chovietz.controller;

import java.util.Objects;
import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chovietz.config.JwtUtils;
import com.chovietz.model.JwtResponse;
import com.chovietz.model.User;
import com.chovietz.repository.UserRepository;
import com.chovietz.service.JwtUserDetailsService;
import com.chovietz.service.UserDetailsImpl;


@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils  jwtUtils;
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User userreq){
    	if(userRepository.findByUsername(userreq.getUsername()) != null) {
    		return ResponseEntity
    				.badRequest()
    				.body("Error");
    	}
    	User user = userRepository.save(new User(userreq.getId(), userreq.getUsername(),encoder.encode(userreq.getPassword()), "customer", userreq.getEmail(),userreq.getCmnd(), userreq.getAddress(), userreq.getBirthday(), userreq.getName(), userreq.getPhoneNumber(), "active"));
    	return ResponseEntity.ok(null);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody User userreq){
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(userreq.getUsername(), userreq.getPassword()));
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	String jwt = jwtUtils.generateJwtToken(authentication);
    	
    	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    	String userRole = userDetails.getRolename();
    	return ResponseEntity.ok(new JwtResponse(jwt, userRole));
    }
    
}