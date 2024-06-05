package web.model;

import jakarta.persistence.*;
import javax.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")
    private String name;

    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 30, message = "Surname must be between 2 and 30 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Surname must contain only letters")
    private String surname;

    public User() {
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        int hash = 31;

        hash = hash * 31 + id;
        hash = hash * 31 + (name == null ? 0 : name.hashCode());
        hash = hash * 31 + (surname == null ? 0 : surname.hashCode());

        return hash;
    }

    @Override
    public String toString() {
        String sb = "User{" + "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
        return sb;
    }
}
