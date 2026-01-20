package com.example.stubservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostUserDto {
    @NotBlank(message = "Логин не может быть пустым")
    @Size(min = 3, max = 20, message = "Длина логина должна быть от 3 до 20 символов")
    private String login;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, max = 30, message = "Длина пароля должна быть от 6 до 30 символов")
    private String password;

    private String date;

    public PostUserDto() {
    }

    public PostUserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
