package com.itacademy.tasktest.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private static final Logger logger = LogManager.getLogger();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String fatherName;
    private String email;
    private Role role;

    public User() {
    }

    public User(String name, String lastName, String fatherName, String email, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        ADMINISTRATOR, SALE_USER, CUSTOMER_USER, SECURE_API_USER;

        public static Role find(String str) {
            for (Role role :
                    Role.values()) {
                if (role.toString().equals(str.toUpperCase())) {
                    logger.log(Level.INFO, "String '{}' was parsed to Role", str);
                    return role;
                }
            }
            return Role.CUSTOMER_USER;
        }
    }
}
