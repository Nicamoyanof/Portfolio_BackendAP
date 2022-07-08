package com.portfolio.portfolio_backendap;


import com.portfolio.portfolio_backendap.Auth.Filter.JWTAuthenticationFilter;
import com.portfolio.portfolio_backendap.Auth.Filter.JWTAuthorizationFilter;
import com.portfolio.portfolio_backendap.services.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig {

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {
        http.cors().configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:80", "http://**", "**", "*"));
                    cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
                    cors.setAllowedHeaders(List.of("*"));
                    return cors;
                })
                .and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationConfiguration.getAuthenticationManager()))
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception
    {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }




}
