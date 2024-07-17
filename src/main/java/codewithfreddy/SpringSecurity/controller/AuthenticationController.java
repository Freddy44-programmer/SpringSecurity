package codewithfreddy.SpringSecurity.controller;

import codewithfreddy.SpringSecurity.dto.JwtAuthenticationResponse;
import codewithfreddy.SpringSecurity.dto.SignUpRequest;
import codewithfreddy.SpringSecurity.dto.SigninRequest;
import codewithfreddy.SpringSecurity.entity.User;
import codewithfreddy.SpringSecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signUpRequest){

        return  ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }


    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){

        return  ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
}
