package com.mycompany.myapp.web.rest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    private Set<String> authorities;

    public UserDTO() {
    }

    public UserDTO(String login, Set<String> authorities) {

        this.login = login;
        this.authorities = authorities;
    }

    public String getLogin() {
        return login;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "login='" + login + '\'' +
            ", authorities=" + authorities +
            "}";
    }
}
