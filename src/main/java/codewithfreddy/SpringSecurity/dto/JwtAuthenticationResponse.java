package codewithfreddy.SpringSecurity.dto;

import codewithfreddy.SpringSecurity.entity.User;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {


    private String token;

    private String refreshToken;


}
