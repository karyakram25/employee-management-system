package net.javaguides.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/api/v1/employees/**")
                        .hasAnyRole("USER","ADMIN")

                        .requestMatchers(HttpMethod.POST,"/api/v1/employees/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT,"/api/v1/employees/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE,"/api/v1/employees/**")
                        .hasRole("ADMIN")

                        .anyRequest().permitAll()
                )
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user123")
                        .roles("USER")
                        .build(),

                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin123")
                        .roles("ADMIN")
                        .build()
        );
    }
}
