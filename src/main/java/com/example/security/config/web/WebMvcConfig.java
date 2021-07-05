package com.example.security.config.web;

import com.example.security.config.interceptor.JwtTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] CLASS_RESOURCE_LOCATIONS = {
            "classpath:/static/", "classpath:/public/", "classpath:/",
            "classpath:/resources/", "classpath:/META-INF/resources/"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 작성한 인터셉터를 추가한다.
        registry.addInterceptor(jwtTokenInterceptor())
                .addPathPatterns("/signin");
    }
/*
    @Bean
    public
    FilterRegistrationBean<HeaderFilter> getFilterRegistrationBean() {
        FilterRegistrationBean<HeaderFilter> registrationBean = new FilterRegistrationBean<>(createHeaderFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public HeaderFilter createHeaderFilter() {
        return new HeaderFilter();
    }
*/


    @Bean
    public JwtTokenInterceptor jwtTokenInterceptor() {
        return new JwtTokenInterceptor();
    }

}
