package com.bloggingapp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    //Name of the comment should not be null or empty
    @NotEmpty(message = "Name of the comment should not be empty")
    @NotNull(message = "Name of the comment should not be null")
    @Size(max = 20, message = "Name should have atmost 20 characters")
    private String name;

    //Email should not be null or empty
    //Email should be valid
    @NotNull(message = "Email should not be null")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    //Comment Body should not be null or empty
    @NotNull(message = "Comment Body should not be null")
    @NotEmpty(message = "Comment Body should not be empty")
    private String body;
}
