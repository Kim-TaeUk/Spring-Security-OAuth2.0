package io.security.ouath2.springsecurityoauth2;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

// AbstractHttpConfigurer는 SecurityConfigurer를 상속 받음
// 첫번째 타입: T extends AbstractHttpConfigurer<T, B>: AbstractHttpConfigurer를 상속받는 클래스 즉, 우리가 만들고자 하는 CustomSecurityConfigurer
// 두번째 타입: B extends HttpSecurityBuilder<B>: HttpSecurityBuilder를 상속받는 클래스, 여기서는 HttpSecurity
public class CustomSecurityConfigurer extends AbstractHttpConfigurer<CustomSecurityConfigurer, HttpSecurity> {

    private boolean isSecure;

    @Override
    public void init(HttpSecurity builder) throws Exception {
        super.init(builder);

        System.out.println("CustomSecurityConfigurer.init");
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);

        System.out.println("CustomSecurityConfigurer.configure");
        if (isSecure) {
            System.out.println("https is required");
        } else {
            System.out.println("https is optional");
        }
    }
}
