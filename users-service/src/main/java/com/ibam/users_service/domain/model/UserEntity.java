package com.ibam.users_service.domain.model;

import java.util.Objects;

import com.ibam.users_service.adapters.jpa.schema.UserSchema.Role;


public class UserEntity {

    //variables
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;


    //constructor
    public UserEntity(){};

    public UserEntity(
        String username,
        String email,
        String password,
        Role role
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }



    //Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
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
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 6 caracteres");
        }
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }


    // Equals and hashCode based on email (unique)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity user = (UserEntity) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
