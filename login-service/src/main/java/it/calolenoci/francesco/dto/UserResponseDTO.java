package it.calolenoci.francesco.dto;


import it.calolenoci.francesco.model.User;

import java.util.Objects;

public class UserResponseDTO {
    private String name;
    private String surname;
    private String username;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String name, String surname, String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public UserResponseDTO(User u) {
        this.name = u.getName();
        this.surname = u.getSurname();
        this.username = u.getUsername();
    }

    @Override
    public String toString() {
        return "UtenteResponseDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDTO that = (UserResponseDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username);
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
