package com.hubo.cloud.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Oauth2ServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        //http
        //        .authorizeHttpRequests((authorize) -> authorize
        //                .antMatchers("/message/**").hasAuthority("SCOPE_message:read")
        //                .anyRequest().authenticated()
        //        ).oauth2ResourceServer((oauth2) -> oauth2.jwt(withDefaults()));
        // @formatter:on

        http.authorizeRequests((authorize) -> authorize
                                .antMatchers("/message/**").hasAuthority("SCOPE_message:read")
                                .anyRequest().authenticated())
                .oauth2ResourceServer((oauth2ResourceServer) -> oauth2ResourceServer.jwt(withDefaults()));
                //.oauth2Login((oauth2Login)->oauth2Login.);
                //.oauth2Client((oauth2Client)->oauth2Client.clientRegistrationRepository())
        //.o
        
        return http.build();
    }
}
