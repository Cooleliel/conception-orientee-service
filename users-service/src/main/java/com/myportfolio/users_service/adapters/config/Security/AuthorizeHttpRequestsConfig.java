package com.myportfolio.users_service.adapters.config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AuthorizeHttpRequestsConfig {

    private final AuthUserDetailsService authUserDetailsService;

    public AuthorizeHttpRequestsConfig(AuthUserDetailsService authUserDetailsService) {
        this.authUserDetailsService = authUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Désactive CSRF (activer si requis)
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/api/public/**").permitAll();  // Routes publiques
                auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();
                auth.requestMatchers(HttpMethod.POST.name(),"/api/users").permitAll(); // Route pour creer (enregistrer) un utilisateur
                auth.requestMatchers("/api/users/sellers/**").hasAnyRole("SELLER", "ADMIN"); // Routes pour utilisateur avec pour Role vendeur
                auth.requestMatchers("/api/users/**").authenticated(); // Routes pour utilisateur cree
                auth.requestMatchers("/api/admin/**").hasRole("ADMIN"); // Routes pour utilisateur avec pour Role admin
                auth.anyRequest().authenticated(); // Autres routes nécessitent une authentification
            })
            .formLogin() // Activer le formulaire de login par défaut
            .and()
            .httpBasic(); // Support HTTP Basic Auth (utile pour Swagger)

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(authUserDetailsService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encode les mots de passe avec BCrypt
    }
}
