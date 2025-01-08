package com.myportfolio.users_service.adapters.jpa.schema;

import java.util.Objects;

import com.myportfolio.users_service.utils.ValidationUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indique que cette classe est une entité JPA qui sera mappée à une table dans une base de données
@Entity
// Spécifie le nom de la table associée à cette entité
@Table(name = "users")
public class UserSchema {
    
    // Déclaration des variables d'instance qui représentent les colonnes de la table "users"
    
    // Identifie la clé primaire de l'entité
    @Id
    // Génère automatiquement une valeur pour la clé primaire (AUTO_INCREMENT dans la base de données)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mappe la colonne "user_name" et impose des contraintes : non-nullable et unique
    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    // Mappe la colonne "email" avec une contrainte d'unicité
    @Column(name = "email", unique = true)
    private String email;

    // Mappe la colonne "password" et impose une contrainte : non-nullable
    @Column(name = "password", nullable = false)
    private String password;

    // Constructeurs
    
    // Constructeur par défaut requis par JPA
    public UserSchema() {}

    // Constructeur avec tous les champs pour initialiser l'entité
    public UserSchema(
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

    // Redéfinit la méthode equals pour comparer les entités en fonction du username
    @Override
    public boolean equals(Object object) {
        if (this == object) { // Vérifie si les deux références pointent au même objet
            return true;
        }
        if (object == null || getClass() != object.getClass()) { // Vérifie la classe de l'objet
            return false;
        }
        UserSchema user = (UserSchema) object;
        return Objects.equals(username, user.username); // Compare les usernames
    }

    // Redéfinit hashCode pour s'assurer que les entités égales ont le même hash
    @Override
    public int hashCode() {
        return Objects.hash(username); // Génère un hash basé sur le username
    }
}

