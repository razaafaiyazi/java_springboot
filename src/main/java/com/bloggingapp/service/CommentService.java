package com.bloggingapp.service;


import com.bloggingapp.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId,CommentDto commentDto);

    List<CommentDto> findCommentByPostId(long postId);
    CommentDto findCommentByCommentId(long postId, long commentId);

    CommentDto updateCommentByCommentId(long commentId,long postId, CommentDto commentDto);

    void deleteCommentByCommentId(long postId, long commentid);
}
