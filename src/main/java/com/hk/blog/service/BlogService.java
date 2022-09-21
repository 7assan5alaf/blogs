package com.hk.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.blog.error.RecordNotFoundException;
import com.hk.blog.model.Blog;
import com.hk.blog.repository.BlogRepository;
import com.hk.blog.view.ApiResopnse;
import com.hk.blog.view.BlogsResponse;

@Service
public class BlogService {
        
	    @Autowired
	    private BlogRepository blogRepository;
	    
	    
	public List<BlogsResponse> findAll() {
		List<Blog>blogs=blogRepository.findAll();
		List<BlogsResponse>list=new ArrayList<>();
		BlogsResponse response=new BlogsResponse();
		for(Blog c:blogs) {
			response.setCategoryName(c.getCategory().getName());
			response.setCover(c.getCover());
			response.setDate(c.getDate());
			response.setEmail(c.getUser().getEmail());
			response.setText(c.getText());
			response.setTitle(c.getTitle());
			response.setUsername(c.getUser().getFullName());
			list.add(response);
		}
		return list;
	}
	public ApiResopnse delete(String id) {
		blogRepository.deleteById(id);
		return new ApiResopnse("delete blog successfully", "success");
	}
	public BlogsResponse viewBlog(String id) {
		Blog b=blogRepository.findById(id).orElseThrow(()->new RecordNotFoundException("blog not found"));
		
		return new BlogsResponse(b.getTitle(), b.getCover(), b.getText(), b.getDate(),
				b.getCategory().getName(),b.getUser().getFullName(),b.getUser().getEmail());
	}
	public Blog findById(String id) {
		return blogRepository.findById(id).orElseThrow(()->new RecordNotFoundException("blog not found"));
	}
	public ApiResopnse editBlog(Blog b) {
		blogRepository.save(b);
		return new ApiResopnse("update successfully", "success");
	}

}
