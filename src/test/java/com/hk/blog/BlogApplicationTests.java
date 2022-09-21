package com.hk.blog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hk.blog.model.User;
import com.hk.blog.repository.UserRepository;

@SpringBootTest
class BlogApplicationTests {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		//given
		User user=new User("7sn 5lf", "isnd sdskjdsjsn sdnsk","7@gmail.com", passwordEncoder.encode("user123"), "minya",null , "1236548880");
		repository.save(user);
	    //when
		 User expecte=repository.findByEmail("7@gmail.com");
		//then
		assertThat(user).isEqualTo(expecte);
	}

}
