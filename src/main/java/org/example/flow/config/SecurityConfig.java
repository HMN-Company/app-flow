package org.example.flow.config;

import org.example.flow.services.impl.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailService userDetailService;

    public SecurityConfig(UserDetailService userInfoService) {
        this.userDetailService = userInfoService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/login", "/assets/**", "/", "/shop-grid", "/shop-grid-sidebar",
                        "/shop-list", "/product-detail", "/cart", "/checkout", "/wishlist", "/track-order",
                        "/about", "/blogs", "/blogs-sidebar", "/blog-detail", "/signup", "/404", 
                        "/coming-soon", "/contact", "/css/**", "/js/**", "/images/**", "/fonts/**",
                        "/webjars/**", "/favicon.ico", "/error", "/assets/media/**", "/assets/js/**",
                        "/assets/css/**", "/assets/fonts/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("JYYKrCvTMs8EgavAsBKmTizD03OD4j3FVq156RegXVk")
                        .tokenValiditySeconds(30 * 24 * 60 * 60)
                )
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logoutSuccessful")
                );
        return http.build();
    }
}