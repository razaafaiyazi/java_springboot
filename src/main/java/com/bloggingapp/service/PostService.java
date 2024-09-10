package com.bloggingapp.service;

import com.bloggingapp.entity.Post;
import com.bloggingapp.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    PostDto savePost(PostDto post);
    List<PostDto> getAllPosts();
    PostDto getpostById(int id);
}
