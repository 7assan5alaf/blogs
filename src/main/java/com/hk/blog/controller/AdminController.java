package com.hk.blog.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hk.blog.model.Category;
import com.hk.blog.model.User;
import com.hk.blog.service.BlogService;
import com.hk.blog.service.CategoryService;
import com.hk.blog.service.ReportService;
import com.hk.blog.service.UserService;
import com.hk.blog.view.ApiResopnse;
import com.hk.blog.view.CategoryResponse;
import com.hk.blog.view.ReportResponse;
import com.hk.blog.view.UserResponse;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReportService reportService;
	//Manage Category
	@PostMapping("/addCategory")
	public ApiResopnse addCategory(@RequestParam MultipartFile image
			,@RequestParam String name) throws Exception {
		return categoryService.addCategory(image,name);
				
	}
	@GetMapping("/viewCategory/{id}")
	public CategoryResponse viewCategory(@PathVariable String id) {
		Category category=categoryService.findById(id);
		return new CategoryResponse(category.getName(),category.getImage());
	}
	@GetMapping("/viewAll")
	public List<Category>findAll(){
		return categoryService.findAll();
	}
	@PutMapping("/editCate")
	public ApiResopnse editCategory(@PathVariable String id,@RequestParam MultipartFile cover
			,@RequestParam String name) throws IOException {
		  Category cateExist=categoryService.findById(id);
		  cateExist.setImage(cover.getBytes());
		  cateExist.setName(name);
		return categoryService.editCategory(cateExist);
	}
	@DeleteMapping
	public ApiResopnse delete(@PathVariable String id) {
		return categoryService.delete(id);
	}
	
	// Manage BLOG
	@DeleteMapping("/deleteBlog")
	public ApiResopnse deleteBlog(@PathVariable String id) {
		return blogService.delete(id);
	}
	//Manage Account
	@PutMapping("/blockUser/{id}")
	public ApiResopnse block(@PathVariable String id) {
		User user=userService.findById(id);
		user.setEnable(false);
		return userService.block(user);
	}
	@GetMapping("/viewUsers")
	public List<UserResponse>getAll(){
		return userService.findAll();
	}
	//Manage Reports
	
	@GetMapping("/reports")
	public List<ReportResponse>allReports(){
		return reportService.findAll();
	}

}
