package com.bloggingapp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class PostDto {
    private long id;

    //Title of the post should not be null or empty
    @NotNull
    @NotEmpty
    private String title;

    //Description of the Post should not be empty or null
    @NotNull
    @NotEmpty
    private String description;

    //Content of the Post should not be empty or null
    @NotNull
    @NotEmpty
    private String content;
}
