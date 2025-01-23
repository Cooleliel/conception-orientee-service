package com.myportfolio.users_service.domain.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myportfolio.users_service.utils.ValidationUtils;
import com.myportfolio.users_service.utils.enums.RoleType;


public class UserModel implements UserDetails{
    // Déclaration des variables d'instance 

    private Long id;

    private String username;

    private String email;

    private String password;

    private RoleType role;

    // Constructeurs
    
    // Constructeur par défaut requis par JPA
    public UserModel() {}

    // Constructeur avec tous les champs pour initialiser l'entité
    public UserModel(
        Long id,
        String username,
        String email,
        String password,
        RoleType role
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters et Setters pour accéder et modifier les champs
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    // Définit l'adresse mail et applique une validation pour le format
    public void setEmail(String email) {
        ValidationUtils.validateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    // Définit le mot de passe et applique une validation pour la longueur
    public void setPassword(String password) {
        ValidationUtils.validatePassword(password);
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }
    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + this.role); // Ex: ROLE_ADMIN, ROLE_USER
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Redéfinit la méthode equals pour comparer les entités en fonction du username
    @Override
    public boolean equals(Object object) {
        if (this == object) { // Vérifie si les deux références pointent au même objet
            return true;
        }
        if (object == null || getClass() != object.getClass()) { // Vérifie la classe de l'objet
            return false;
        }
        UserModel user = (UserModel) object;
        return Objects.equals(username, user.username); // Compare les usernames
    }

    // Redéfinit hashCode pour s'assurer que les entités égales ont le même hash
    @Override
    public int hashCode() {
        return Objects.hash(username); // Génère un hash basé sur le username
    }
}
