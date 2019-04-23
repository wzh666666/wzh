package com.juzheng.util;


import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import com.juzheng.entity.code.TokenDetail;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class Jwt {
    private Key key ;
    private String theme;
    private SignatureAlgorithm signatureAlgorithm;
    public Jwt() {
//        key = MacProvider.generateKey();
//        key = MacProvider.generateKey();
        signatureAlgorithm = SignatureAlgorithm.HS512;
        theme = "居正周安排";
        String  encodedKey =
                "YHV8VSrfvxgjGJfWazilJQwPEFUT0njdmBrBe5HPBuM";
        key = deserializeKey(encodedKey);
    }

    private Key deserializeKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        Key key =
                new SecretKeySpec(decodedKey, getSignatureAlgorithm().getJcaName());
        return key;
    }

    public String getAuthToken(TokenDetail tokenDetail){

        String compactJws = Jwts.builder()
                .setSubject(getTheme())
                .setId(tokenDetail.getId().toString())
                .claim("username", tokenDetail.getName())
                .claim("usertel", tokenDetail.getTel())
                .setExpiration(tokenDetail.getExpirationDate())
                .signWith(getSignatureAlgorithm(), getSecretKey())
                .compact();
        return compactJws;
    }


    public Claims verifyToken(String token){
//        Claims claims =Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
//        System.out.println("ID: " + claims.getSubject());
//        assert Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody().getSubject().equals(getTheme());
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(token).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public TokenDetail getTokenParams(String token){
        TokenDetail tokenDetail = null;
        try {
            Claims claims =
                    Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
            String userId = claims.getSubject();
            String username = (String) claims.get("username");
            String usertel = (String) claims.get("usertel");
            Date expirationDate = claims.getExpiration();
            tokenDetail = new TokenDetail();
            tokenDetail.setId(Integer.valueOf(userId));
            tokenDetail.setName(username);
            tokenDetail.setTel(usertel);
            tokenDetail.setExpirationDate(expirationDate);
        } catch (JwtException ex) {
            System.out.println(ex.getMessage());
        }
        return tokenDetail;
    }

    public SignatureAlgorithm getSignatureAlgorithm() {
        return signatureAlgorithm;
    }
    private Key getSecretKey() {
        return key;
    }
    private String getTheme(){
        return theme;
    }
}
