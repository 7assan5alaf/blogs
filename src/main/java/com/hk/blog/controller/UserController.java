package com.hk.blog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hk.blog.model.Blog;
import com.hk.blog.model.Category;
import com.hk.blog.model.Report;
import com.hk.blog.model.User;
import com.hk.blog.service.BlogService;
import com.hk.blog.service.CategoryService;
import com.hk.blog.service.ReportService;
import com.hk.blog.service.UserService;
import com.hk.blog.view.ApiResopnse;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService; 
	@Autowired 
	private BlogService blogService;
	@Autowired
	private ReportService reportService;
	//Manage Blog
	@PostMapping("/addBlog")
	public 	ApiResopnse addBlog(@RequestParam MultipartFile cover,@RequestParam String title,@RequestParam String text,
			@RequestParam String categoryId,@RequestParam String userId
			) throws Exception {
		
		User user=userService.findById(userId);
		Category category=categoryService.findById(categoryId);
		return userService.addBlog(cover,title,text,user,category);
	}
	
	@DeleteMapping("/deleteBlog")
	public ApiResopnse deleteBlog(@PathVariable String id) {
		return blogService.delete(id);
	}
	
	@PutMapping("/editBlog")
	public ApiResopnse editBlog(@PathVariable String id,@RequestParam MultipartFile cover,@RequestParam String title,@RequestParam String text,
			@RequestParam String categoryId) throws IOException {
		Blog b=blogService.findById(id);
		b.setCategory(categoryService.findById(categoryId));
		b.setCover(cover.getBytes());
		b.setText(text);
		b.setTitle(title);
		return blogService.editBlog(b);
		
	}
	
	// Manage Account
	@PutMapping("/editProfile/{id}")
	public ApiResopnse editProfile(@PathVariable String id,@RequestParam MultipartFile image,
			@RequestParam String bio,@RequestParam String phone,@RequestParam String fullName,@RequestParam
			 String address) throws IOException {
		User user=userService.findById(id);
		user.setAddress(address);
		user.setBio(bio);
		user.setImage(image.getBytes());
		user.setFullName(fullName);
		user.setPhone(phone);
		return userService.editProfile(user);
		
	}
	
    //create report 
	@PostMapping("/createReport/{blogId}")
	public ApiResopnse createReort(@PathVariable String blogId,@RequestBody Report report) {
		return reportService.addReport(blogId,report);
	}
	
}
