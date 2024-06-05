package com.example.kojin.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class InsertForm {

    @NotBlank(message = "曲名は必須です")
    private String song;
    private int id;
    @NotBlank(message = "曲idは必須です")
    private String songId;

}
