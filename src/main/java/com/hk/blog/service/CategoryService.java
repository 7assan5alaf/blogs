package com.hk.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hk.blog.model.Category;
import com.hk.blog.repository.CategoryRepository;
import com.hk.blog.view.ApiResopnse;

@Service
public class CategoryService {
     @Autowired
     private CategoryRepository categoryRepository;
	 
	public Category findById(String categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(null);
	}

	public ApiResopnse addCategory(MultipartFile image, String name) throws Exception {
		 Category category=new Category();
		String fileName=StringUtils.cleanPath(image.getOriginalFilename());
		if(fileName.contains(".."))
			 throw new Exception("sorry! file contains invaild path sequence "+ fileName);
		category.setImage(image.getBytes());
		category.setName(name);
		categoryRepository.save(category);
		return new ApiResopnse("add new category","success");
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	public ApiResopnse editCategory(Category cateExist) {
		categoryRepository.save(cateExist);
		return new ApiResopnse("update category successfully", "success");
	}

	public ApiResopnse delete(String id) {
		categoryRepository.deleteById(id);
		return new ApiResopnse("delete successfully","success");
	}

}
