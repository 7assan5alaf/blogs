package com.hk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hk.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

	User findByEmail(String email);
}
