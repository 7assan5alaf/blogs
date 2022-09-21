package com.hk.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hk.blog.dto.UserSginIn;
import com.hk.blog.dto.UserSginUp;
import com.hk.blog.error.RecordNotFoundException;
import com.hk.blog.message.EmailSender;
import com.hk.blog.message.Message;
import com.hk.blog.model.Blog;
import com.hk.blog.model.Category;
import com.hk.blog.model.User;
import com.hk.blog.repository.BlogRepository;
import com.hk.blog.repository.UserRepository;
import com.hk.blog.view.ApiResopnse;
import com.hk.blog.view.BlogsResponse;
import com.hk.blog.view.ForgetResponse;
import com.hk.blog.view.ProfileResponse;
import com.hk.blog.view.UserResponse;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findById(String userId) {
	    User user=repository.findById(userId).orElseThrow(()->new RecordNotFoundException("user not found"));
	    return user;
	}

	public ApiResopnse addBlog(MultipartFile cover, String title, String text, User user, Category category) throws Exception {
		String filName=StringUtils.cleanPath(cover.getOriginalFilename());
		Blog blog=new Blog();
		if(filName.contains(".."))
		  throw new Exception("sorry! file contains invaild path sequence "+ filName);
		blog.setCategory(category);
		blog.setCover(cover.getBytes());
		blog.setDate(new Date());
		blog.setText(text);
		blog.setUser(user);
		blog.setTitle(title);
		blogRepository.save(blog);
		return new ApiResopnse("add new blog", "success");
	}
	
	public User addUser(User user) {
		return repository.save(user);
	}

	public ApiResopnse editProfile(User user) {
		repository.save(user);
		return new ApiResopnse("update profile successfully","success");
	}

	public ApiResopnse block(User user) {
		repository.save(user);
		return new ApiResopnse("block of user successfully","success");
	}

	public ApiResopnse sginUp(UserSginUp user) throws MessagingException {
		Message message=new Message();
		User userExist=repository.findByEmail(user.getEmail());
		if(Objects.nonNull(userExist)) {
			emailSender.sendEmail(userExist.getEmail(),message.getSubject(),
		"Hi "+user.getFullName()+"\nEmail is already registered");
			return new ApiResopnse("Email is already registered", "invalid");
		}
		
		userExist=new User();
        userExist.setAddress(user.getAddress());
        userExist.setEmail(user.getEmail());
        userExist.setFullName(user.getFullName());
        if(user.getOnePassword().equals(user.getTowPassword())) {
        	userExist.setPassword(passwordEncoder.encode(user.getOnePassword()));
        }else {
        	return new ApiResopnse("invalid password", "invalid");
        }
        userExist.setPhone(user.getPhone());
        userExist.setRole("USER");
        repository.save(userExist);
    	emailSender.sendEmail(user.getEmail(), message.getSubject(), message.getMessageUser());
		return new ApiResopnse("register successfully", "success");
	}

	public ApiResopnse sginIn(UserSginIn sginIn) {
		User user=repository.findByEmail(sginIn.getEmail());
		if (Objects.isNull(user)||!passwordEncoder.matches(sginIn.getPassword(), user.getPassword())) {
			return new ApiResopnse("invalid username and passsword", "invalid");
		}
		if(!user.isEnable()) {
			return new ApiResopnse("this account is already blocked", "invalid");
		}
		
		return new ApiResopnse("login successfully", "success");
	}

	public ProfileResponse viewProfile(String id) {
		User user=findById(id);
		List<Blog>blogs=blogRepository.findAllByUserId(id);
		List<BlogsResponse>list=new ArrayList<>();
		for(Blog b:blogs) {
			list.add(new BlogsResponse(b.getTitle(), b.getCover(), b.getText(),b.getDate(),b.getCategory().getName()
					,b.getUser().getFullName(),b.getUser().getEmail()));
		}
		return new ProfileResponse(user.getEmail(),user.getFullName(), user.getAddress(),list);
	}

	public ApiResopnse changePassword(String id, String password, String confirmPassword) {
		ApiResopnse resopnse;
		User user=findById(id);
		if(password.equals(confirmPassword)) {
			user.setPassword(passwordEncoder.encode(confirmPassword));
			resopnse=new ApiResopnse("change successfully", "success");
		}else {
			resopnse=new ApiResopnse("invaild password", "invaild");
		}
		return resopnse;
	}

	public ForgetResponse forgetPassword(String email) throws MessagingException {
		User user=repository.findByEmail(email);
		ForgetResponse response;
		if(Objects.isNull(user)) {
			response=new ForgetResponse("invalid username", "not exist");
		}else {
			emailSender.sendEmail(user.getEmail(), "forget password", "Hi "+user.getFullName()+
					"\n"+"http://localhost:8081/api/home/changePassword/"+user.getId());
			
			response=new ForgetResponse("Change Your Password","http://localhost:8081/api/home/changePassword/"+user.getId());
		}
		
		return response;
	}

	public List<UserResponse> findAll() {
		List<User>users=repository.findAll();
		List<UserResponse>list=new ArrayList<>();
		for(User user:users) {
			list.add(new UserResponse(user.getId(), user.getFullName(), user.getEmail(),user.getImage()));
		}
		
		return list;
	}

}
