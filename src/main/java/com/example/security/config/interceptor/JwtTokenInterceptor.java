package com.example.security.config.interceptor;

import com.example.security.constants.AuthConstants;
import com.example.security.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String header = request.getHeader(AuthConstants.AUTH_HEADER);
        if (header != null) {
            String token = TokenUtils.getTokenFromHeader(header);
            if (TokenUtils.isValidToken(token)) {
                System.out.println();
                return true;
            }
        }
        //error page redirect
        return false;
    }
}
