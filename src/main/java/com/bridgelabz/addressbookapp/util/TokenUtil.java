package com.bridgelabz.addressbookapp.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    private static final String Token_Secret = "Book";
    public  String createToken(Long personId){

        try {

            Algorithm algorithm = Algorithm.HMAC256(Token_Secret);
            String token = JWT.create()
                    .withClaim("personId" , personId)
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            exception.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }

    public Long decodeToken(String token){
        Long personId;
        Saml2RelyingPartyProperties.AssertingParty.Verification verification = null;
        try {
            verification = (Saml2RelyingPartyProperties.AssertingParty.Verification) JWT.require(Algorithm.HMAC256(Token_Secret));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        JWTVerifier jwtVerifier = ((Verification) verification).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Claim claim = decodedJWT.getClaim("personId");
        personId=claim.asLong();
        return personId;
    }




}
