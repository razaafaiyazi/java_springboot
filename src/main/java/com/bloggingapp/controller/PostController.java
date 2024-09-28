package com.bloggingapp.controller;


import com.bloggingapp.payload.PostDto;
import com.bloggingapp.payload.PostResponse;
import com.bloggingapp.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto){
        PostDto postDto1 = postService.savePost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo",defaultValue = "0", required = false) int pageNo,
                                                     @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                     @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                                     @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir){
        PostResponse postResponse = postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return postResponse;
    }
    //http://localhost:8080/api/posts/id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable("id") int id){
        PostDto postDto = postService.getpostById(id);
        return new ResponseEntity<>(postDto,HttpStatus.CREATED);
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto){
        PostDto updatedPost = postService.updatePost(postDto);
        return new ResponseEntity<>(updatedPost,HttpStatus.CREATED);
    }
    //delete post by id
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletePostById(@PathVariable("id") int id){
        String deleteMsg = postService.deletePost(id);
        return new ResponseEntity<>(deleteMsg,HttpStatus.OK);
    }

}
