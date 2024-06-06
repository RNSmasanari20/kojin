package com.example.kojin.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {
    private int id;
    @NotBlank(message = "IDは必須です")
    private String login_id;
    @NotBlank(message = "パスワードは必須です")
    private String password;
    @NotBlank(message = "ユーザー名は必須です")
    private String name;
    private int role;
}
