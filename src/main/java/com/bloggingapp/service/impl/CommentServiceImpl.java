package com.bloggingapp.service.impl;

import com.bloggingapp.entity.Comment;
import com.bloggingapp.entity.Post;
import com.bloggingapp.exception.ResourceNotFoundException;
import com.bloggingapp.payload.CommentDto;
import com.bloggingapp.payload.PostResponse;
import com.bloggingapp.repository.CommentRepository;
import com.bloggingapp.repository.PostRepository;
import com.bloggingapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        Comment comment = this.mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return this.mapToDto(savedComment);
    }

    private CommentDto mapToDto(Comment savedComment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody(savedComment.getBody());
        commentDto.setName(savedComment.getName());
        commentDto.setEmail(savedComment.getEmail());
        commentDto.setId(savedComment.getId());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        return  comment;
    }
}
