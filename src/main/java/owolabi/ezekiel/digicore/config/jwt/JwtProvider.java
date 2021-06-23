package owolabi.ezekiel.digicore.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtProvider {
  @Value("$(jwt.secret)")
  private String jwtSecret;

  public String generateToken(String accountNumber) {
    Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
    return Jwts.builder().setSubject(accountNumber).setExpiration(date)
        .signWith(SignatureAlgorithm.HS512, "jwtSecret").compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey("jwtSecret").parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  public String getAccountNumberFromToken(String token){
    Claims claims = Jwts.parser().setSigningKey("jwtSecret").parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
