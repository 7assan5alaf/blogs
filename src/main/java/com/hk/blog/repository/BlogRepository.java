package com.hk.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hk.blog.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
	List<Blog>findAllByUserId(String id);

}
