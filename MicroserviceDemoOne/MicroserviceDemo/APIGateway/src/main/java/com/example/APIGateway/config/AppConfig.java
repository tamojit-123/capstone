package com.example.APIGateway.config;

import com.example.APIGateway.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes()
//                .route(p->p .path("/api/v1/**") .uri("http://localhost:8085/"))
//                .route(p->p .path("/api/v2/**") .uri("http://localhost:8081/"))
                //with eurek
                .route(p->p .path("/api/v1/**") .uri("lb://user-authentication-service"))
              .route(p->p .path("/api/v2/**") .uri("lb://user-movie-service"))
                .build();
    }

    @Bean
    public FilterRegistrationBean jwtFilterBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/v1/user/*");
        return filterRegistrationBean;
    }
}
