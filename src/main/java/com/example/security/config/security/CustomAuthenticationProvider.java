package com.example.security.config.security;

import com.example.security.app.dto.UserDetailsVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        //AuthenticationFilter(UsernamePasswordAuthenticationToken)
        //에서 생성된 토큰으로부터 아이디와 비밀번호를 조회함
        String userEmail = token.getName();
        String userPw = (String) token.getCredentials();

        UserDetailsVO userDetailsVO = (UserDetailsVO) userDetailsService.loadUserByUsername(userEmail);


        /*
         validate password
         if (!passwordEncoder.matches(userPw, userDetailsVO.getPassword())) {
            throw new BadCredentialsException(userDetailsVO.getUsername() + "Invalid password");
        }*/

        return new UsernamePasswordAuthenticationToken(userDetailsVO,userDetailsVO.getPassword(),userDetailsVO.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //여기는 동일한 TokenClass인지 확인하는 ?
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
