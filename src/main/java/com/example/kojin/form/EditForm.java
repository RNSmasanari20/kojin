package com.example.kojin.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EditForm {

    private int id;
    @NotBlank(message = "曲名は必須です")
    private String name;
    private int genreId;
    @NotBlank(message = "曲idは必須です")
    private String songId;
}
