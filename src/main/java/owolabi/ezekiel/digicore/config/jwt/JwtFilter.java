package owolabi.ezekiel.digicore.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;
import owolabi.ezekiel.digicore.CustomUserDetailsService;
import owolabi.ezekiel.digicore.config.CustomUserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Component
public class JwtFilter extends OncePerRequestFilter {
  public static final String AUTHORIZATION = "Authorization";

  @Autowired
  private JwtProvider jwtProvider;
  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  public String getTokenFromRequest(HttpServletRequest request){
    String bearer = request.getHeader(AUTHORIZATION);
    if(hasText(bearer) && bearer.startsWith("Bearer ")){
      return bearer.substring(7);
    }
    return null;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String token = getTokenFromRequest(httpServletRequest);
    if(token != null && jwtProvider.validateToken(token)){
      String accountNumber = jwtProvider.getAccountNumberFromToken(token);
      CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(accountNumber);
      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails,null, customUserDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(auth);
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
