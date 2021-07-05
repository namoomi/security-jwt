package com.example.security.handler;

import com.example.security.app.dto.UserDetailsVO;
import com.example.security.app.entity.User;
import com.example.security.constants.AuthConstants;
import com.example.security.utils.TokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = ((UserDetailsVO) authentication.getPrincipal()).getUser();
        //token generate with userInfo arg
        String token = TokenUtils.generateJWT(user);
        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
    }
}
