package com.app.bankapp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class Helpers {

  public static enum Status {
    ACTIVE,
    INACTIVE,
    CLOSED,
  }

  public static String secretKey = "mySecretKey";

  public static Boolean isEmailValid(String email) {
    String regex = "^(.+)@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public static String getJWTToken(String username) {
    String secretKey = "mySecretKey";
    List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
      "ROLE_USER"
    );
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, 30);

    String token = Jwts
      .builder()
      .setId(UUID.randomUUID().toString())
      .setSubject(username)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .claim(
        "authorities",
        grantedAuthorities
          .stream()
          .map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList())
      )
      .setExpiration(c.getTime())
      .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
      .compact();

    return "Bearer " + token;
  }

  public static String parseJWT(String jwtToken) {
    jwtToken = jwtToken.split(" ")[1];
    Claims claims = Jwts
      .parser()
      .setSigningKey(Helpers.secretKey.getBytes())
      .parseClaimsJws(jwtToken)
      .getBody();
    return claims.getSubject();
  }
}
