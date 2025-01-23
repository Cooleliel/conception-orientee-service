package com.myportfolio.users_service.usescases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myportfolio.users_service.domain.gateway.UserGateway;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserGateway gateway;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return gateway.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec cet username: " + username));
    }
}
