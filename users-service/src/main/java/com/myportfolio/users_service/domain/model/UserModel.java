package com.myportfolio.users_service.domain.model;

import java.util.Objects;


public class UserModel {
    // Déclaration des variables d'instance 

    private Long id;

    private String username;

    private String email;

    private String password;

    // Constructeurs
    
    // Constructeur par défaut requis par JPA
    public UserModel() {}

    // Constructeur avec tous les champs pour initialiser l'entité
    public UserModel(
        Long id,
        String username,
        String email,
        String password
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    // Définit le mot de passe et applique une validation pour la longueur
    public void setPassword(String password) {
        if(password.length() < 8) {
            throw new RuntimeException("Au moins huit (08) caractères requis!");
        }
        this.password = password;
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
