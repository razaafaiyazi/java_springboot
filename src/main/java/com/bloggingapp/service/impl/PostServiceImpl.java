package com.bloggingapp.service.impl;

import com.bloggingapp.entity.Post;
import com.bloggingapp.exception.ResourceNotFoundException;
import com.bloggingapp.payload.PostDto;
import com.bloggingapp.repository.PostRepository;
import com.bloggingapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public PostDto savePost(PostDto post) {
        //conver dto to entity
        Post p = mapToEntity(post);
        Post save = postRepository.save(p);
        PostDto postDto = mapToDto(save);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts.stream().map(post->mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getpostById(int id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        return this.mapToDto(post);
    }

    private PostDto mapToDto(Post save) {
        PostDto postDto = new PostDto();
        postDto.setId(save.getId());
        postDto.setTitle(save.getTitle());
        postDto.setDescription(save.getDescription());
        postDto.setContent(save.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto post) {
        Post p = new Post();
        p.setId(post.getId());
        p.setTitle(post.getTitle());
        p.setDescription(post.getDescription());
        p.setContent(post.getContent());
        return p;
    }
}
