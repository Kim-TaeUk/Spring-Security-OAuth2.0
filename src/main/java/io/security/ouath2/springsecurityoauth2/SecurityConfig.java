package io.security.ouath2.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity이 @Configuration를 가지고 있기 때문에 둘 다 가능
//@EnableWebSecurity

// bean을 만들고 있기 때문에 @Configuration로 사용
@Configuration
public class SecurityConfig {

    // SecurityFilterChain 타입의 bean 생성
    // bean이기 때문에 HttpSecurity을 의존성 주입받을 수 있음
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        http
                .formLogin();
        return http.build();
    }
}
