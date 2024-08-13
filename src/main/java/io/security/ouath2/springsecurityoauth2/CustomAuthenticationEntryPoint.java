package io.security.ouath2.springsecurityoauth2;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // RFC 7235 표준에 명시: spec을 정확히 지켜주어야 함. WWW-Auth 이런식이면 클라이언트가 인증 요청으로 인식하지 못함
        // -> Basic Authentication 방식을 사용해 "localhost" 영역에 대해 인증할 것을 요구함
        response.addHeader("WWW-Authenticate", "Basic realm=localhost" + "\"");
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }
}
