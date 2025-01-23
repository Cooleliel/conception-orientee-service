package com.myportfolio.users_service.adapters.config.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myportfolio.users_service.domain.gateway.UserGateway;

public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserGateway gateway;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return gateway.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec cet username: " + username));
    }

    public Authentication getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }
}