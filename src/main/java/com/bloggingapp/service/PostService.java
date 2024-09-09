package com.bloggingapp.service;

import com.bloggingapp.entity.Post;
import com.bloggingapp.payload.PostDto;
import org.springframework.stereotype.Service;


public interface PostService {
    PostDto savePost(PostDto post);
}
