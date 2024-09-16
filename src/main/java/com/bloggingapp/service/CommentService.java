package com.bloggingapp.service;


import com.bloggingapp.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId,CommentDto commentDto);
}
