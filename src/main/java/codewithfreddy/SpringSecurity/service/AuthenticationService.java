package codewithfreddy.SpringSecurity.service;

import codewithfreddy.SpringSecurity.dto.JwtAuthenticationResponse;
import codewithfreddy.SpringSecurity.dto.SignUpRequest;
import codewithfreddy.SpringSecurity.dto.SigninRequest;

public interface AuthenticationService {

  JwtAuthenticationResponse signup(SignUpRequest signUpRequest);

  JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
