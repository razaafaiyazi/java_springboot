package com.bloggingapp.repository;

import com.bloggingapp.entity.Comment;
import com.bloggingapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

}
