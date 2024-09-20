package com.bloggingapp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    //Name of the comment should not be null or empty
    @NotEmpty
    @NotNull
    private String name;

    //Email should not be null or empty
    //Email should be valid
    @NotNull
    @NotEmpty
    @Email
    private String email;

    //Comment Body should not be null or empty
    @NotNull
    @NotEmpty
    private String body;
}
