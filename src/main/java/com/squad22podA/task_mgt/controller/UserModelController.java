package com.squad22podA.task_mgt.controller;


import com.squad22podA.task_mgt.utility.JwtService;
import com.squad22podA.task_mgt.payload.request.UserLoginRequest;
import com.squad22podA.task_mgt.payload.request.UserRegistrationRequest;
import com.squad22podA.task_mgt.payload.response.UserLoginResponse;
import com.squad22podA.task_mgt.service.UserModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserModelController {

    private final UserModelService userModelService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationRequest registrationRequest) {

        try{
            userModelService.registerUser(registrationRequest);
            return ResponseEntity.ok("User registered successfully. Please check your email to confirm your account");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }


    @PostMapping("/login")
    public UserLoginResponse loginUser(@RequestBody UserLoginRequest userLoginRequest){

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginRequest.getEmail(), userLoginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String jwt = jwtService.generateToken((UserDetails) authenticate.getPrincipal());

        return new UserLoginResponse(jwt);
    }
}
