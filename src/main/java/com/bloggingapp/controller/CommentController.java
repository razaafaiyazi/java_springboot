package com.bloggingapp.controller;

import com.bloggingapp.payload.CommentDto;
import com.bloggingapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<CommentDto> saveComment(@PathVariable("id") long id,@RequestBody CommentDto commentDto){
        CommentDto commentDt = commentService.createComment(id, commentDto);
        return new ResponseEntity<>(commentDt, HttpStatus.CREATED);
    }
}
