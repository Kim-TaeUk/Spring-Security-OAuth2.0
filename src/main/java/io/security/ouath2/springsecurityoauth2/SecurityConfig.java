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

    /*
    // SecurityFilterChain 타입의 bean 생성
    // bean이기 때문에 HttpSecurity을 의존성 주입받을 수 있음
    @Bean
    SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        http
                .formLogin();

        // apply는 configurer를 받아서 configurer를 return함
        // 그렇기 때문에 CustomSecurityConfigurer.setFlag의 return type을 CustomSecurityConfigurer로 설정
        // chaining이 가능해짐! .setFlag1().setFlag2() 이런 식으로

        // auto configuration에 의해 configurers에 넣어지고, custom으로 만들어준 CustomSecurityConfigurer도 들어가게 됨
        // init -> configure -> setFlag까지 쭉 실행됨
//        http.apply(new CustomSecurityConfigurer().setFlag(true));
        return http.build();
    }
    */

    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        http
                .httpBasic();

        return http.build();
    }

    // SecurityFilterChains를 열어보면 2개의 SecurityFilterChain가 존재,
    // securityFilterChain1로 만들어진건 form login이기 때문에 UserNamePasswordAuthenticationFilter가 포함됨
    // securityFilterChain2로 만들어진건 basic login이기 때문에 BasicAuthenticationFilter가 포함됨
    // 물론 filter 개수도 다름!
}
