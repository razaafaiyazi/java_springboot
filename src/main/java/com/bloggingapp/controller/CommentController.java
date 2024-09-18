package com.bloggingapp.controller;

import com.bloggingapp.entity.Comment;
import com.bloggingapp.payload.CommentDto;
import com.bloggingapp.service.CommentService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //get all comments by post id
    @GetMapping("/{id}")
    public ResponseEntity<List<CommentDto>> getCommentByPostId(@PathVariable("id") long postId){
        return new ResponseEntity<>(commentService.findCommentByPostId(postId),HttpStatus.OK);
    }
    //get comments by comment id
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentByCommentId(
            @PathVariable("postId") long postId,
            @PathVariable("id") long commentId
    ){
        CommentDto commentByCommentId = commentService.findCommentByCommentId(postId, commentId);
        return new ResponseEntity<>(commentByCommentId,HttpStatus.OK);
    }
    // update comments by comment id
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@RequestBody CommentDto commentDto,
                                                        @PathVariable("id") long commentId,
                                                        @PathVariable("postId") long postId){
        CommentDto commentDto1 = commentService.updateCommentByCommentId(commentId, postId, commentDto);
        return new ResponseEntity<>(commentDto1, HttpStatus.OK);
    }
    //delete comment by comment id
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteCommentByCommentId(@PathVariable("postId") long postId,
                                           @PathVariable("id") long commentid){
        commentService.deleteCommentByCommentId(postId,commentid);
        return new ResponseEntity<>("Comment deleted Successfully!!",HttpStatus.OK);
    }
}
