package com.bloggingapp.service.impl;

import com.bloggingapp.entity.Post;
import com.bloggingapp.exception.ResourceNotFoundException;
import com.bloggingapp.payload.PostDto;
import com.bloggingapp.payload.PostResponse;
import com.bloggingapp.repository.PostRepository;
import com.bloggingapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        //creating Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
      //  List<Post> allPosts = postRepository.findAll();
        Page<Post> pagePost = postRepository.findAll(pageable);
        // get content from Page object
        List<Post> allPosts = pagePost.getContent();
        List<PostDto> dtos = allPosts.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(dtos);
        postResponse.setLast(pagePost.isLast());
        postResponse.setPageNo(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setTotalElements(pagePost.getTotalElements());

         return postResponse;
    }

    @Override
    public PostDto getpostById(int id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        return this.mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        int id = postDto.getId();
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        Post updatedPost = postRepository.save(post);
        PostDto updatedPostDto = this.mapToDto(updatedPost);
        return updatedPostDto;
    }

    @Override
    public String deletePost(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
        postRepository.delete(post);
        return "Post Deleted with Id "+id;
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
