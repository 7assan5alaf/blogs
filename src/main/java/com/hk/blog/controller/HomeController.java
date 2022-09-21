package com.hk.blog.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.blog.dto.UserSginIn;
import com.hk.blog.dto.UserSginUp;
import com.hk.blog.service.BlogService;
import com.hk.blog.service.UserService;
import com.hk.blog.view.ApiResopnse;
import com.hk.blog.view.BlogsResponse;
import com.hk.blog.view.ForgetResponse;
import com.hk.blog.view.ProfileResponse;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;
      	
	@GetMapping("/viewBlogs")
	public List<BlogsResponse>findAll(){
		return blogService.findAll();
	}
	@GetMapping("/viewBlog/{id}")
	public BlogsResponse viewBlog(@PathVariable String id) {
		return blogService.viewBlog(id);
	}
	@PostMapping("/sginUp")
	public ApiResopnse sginUp(@RequestBody UserSginUp user) throws MessagingException {
		return userService.sginUp(user);
	}
	
	@PostMapping("/sginIn")
	public ApiResopnse sginIn(@RequestBody UserSginIn sginIn) {
		return userService.sginIn(sginIn);
	}
	
	@GetMapping("/viewProfile/{id}")
	public ProfileResponse viewProfile(@PathVariable String id) {
		return userService.viewProfile(id);
	}
	@PutMapping("/changePassword/{id}")
	public ApiResopnse changePassword( @PathVariable String id,@RequestParam String password
			, @RequestParam String confirmPassword) {
		return userService.changePassword(id,password,confirmPassword);
		
	}
	@GetMapping("/forgetPassword")
	public ForgetResponse forgetPassword(@RequestParam String email) throws MessagingException {
		return userService.forgetPassword(email);
	}
}
