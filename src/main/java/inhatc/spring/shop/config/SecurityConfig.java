package inhatc.spring.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * packageName    : inhatc.spring.shop.config
 * fileName       : SecurityConfig
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    : Spring Security 설정
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 보안 설정
        http.formLogin(form -> form
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/member/login/error")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll());

//        http.logout(Customizer.withDefaults());
//
//        // 접근 제어
//        http.authorizeHttpRequests(request -> request
//                .requestMatchers("/css/**").permitAll()             // CSS 접근 허용
//                .requestMatchers("/", "/member/**").permitAll()   // 접근 허용할 페이지 지정
//                .anyRequest().authenticated());                       // 허용되지 않은 모든 페이지는 인가 없이 접근 불가능
//
//        // 에러 핸들링
//        http.exceptionHandling(exception -> exception
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
