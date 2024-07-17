package codewithfreddy.SpringSecurity.service.impl;


import codewithfreddy.SpringSecurity.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtServiceImpl implements JwtService {


    public  static final  String SECRET = "5f001a0524dd5c3eb33fca015ac1ba35b2338c19108b5a525b072abbbf7ed48537b60097a1fd7103606458cec1b25c6a0ea27c0accf789de03d0bf6530d1dd4f";


    public String generateToken(UserDetails userDetails) {

        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(geSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(geSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String extractUserName(String token){

        return  extractClaim(token, Claims::getSubject);
    }




    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }


    private Key geSiginKey() {

        byte[] key = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(key);
    }


    private Claims extractAllClaims (String token){

        return Jwts.parserBuilder().setSigningKey(geSiginKey()).build().parseClaimsJws(token).getBody();
    }


    public  boolean isTokenValid(String token, UserDetails userDetails){

        final String username = extractUserName(token);
        return  (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    private  boolean isTokenExpired(String token){

        return  extractClaim(token, Claims::getExpiration).before(new Date());
    }

}
