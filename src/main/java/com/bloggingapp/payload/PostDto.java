package com.bloggingapp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class PostDto {
    private long id;

    //Title of the post should not be null or empty
    @NotNull(message = "Title of the post should not be null ")
    @NotEmpty(message = "Title of the post should not be empty")
    @Size(min = 2, message = "size of the title should be more than 2")
    private String title;

    //Description of the Post should not be empty or null
    @NotNull(message = "Description of the Post should not be null")
    @NotEmpty(message = "Description of the Post should not be empty")
    private String description;

    //Content of the Post should not be empty or null
    @NotNull(message = "Content of the Post should not be null")
    @NotEmpty(message = "Content of the Post should not be empty")
    private String content;
}
