package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                 .and()
                .csrf().disable()
                //기본 설정을 쓸게요
                .cors(Customizer.withDefaults())
                .formLogin().disable()
                //http요청 헤더에 담아서 보내던걸 비활성화
                .httpBasic().disable()
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
    return http.build();
    }
}
