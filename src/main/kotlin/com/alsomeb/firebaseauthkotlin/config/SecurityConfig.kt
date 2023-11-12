package com.alsomeb.firebaseauthkotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
         http.authorizeHttpRequests {
            it.anyRequest()
                .authenticated()
        }

        http.csrf{it.disable()}
        http.httpBasic(Customizer.withDefaults())
        http.sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}

        http.oauth2ResourceServer{it.jwt(Customizer.withDefaults())}

        return http.build();
    }
}
