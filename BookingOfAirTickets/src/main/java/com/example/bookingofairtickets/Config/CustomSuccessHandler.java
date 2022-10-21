package com.example.bookingofairtickets.Config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach((a) -> {
            if(a.getAuthority().equals("ROLE_ADMIN")){
                try {
                    redirectStrategy.sendRedirect(request,response,"/airline/admin/");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } if(a.getAuthority().equals("ROLE_USER")){
                try {
                    redirectStrategy.sendRedirect(request,response,"/airline/");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
