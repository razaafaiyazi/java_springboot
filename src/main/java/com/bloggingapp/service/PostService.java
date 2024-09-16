package com.bloggingapp.service;

import com.bloggingapp.entity.Post;
import com.bloggingapp.payload.PostDto;
import com.bloggingapp.payload.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    PostDto savePost(PostDto post);

    PostDto getpostById(long id);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto updatePost(PostDto postDto);
    public String deletePost(long id);
}
