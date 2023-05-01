package com.encodeURLApp.UserDataService;

import com.encodeURLApp.UserDataService.model.User;
import com.encodeURLApp.UserDataService.repository.UserDAL;
import com.encodeURLApp.UserDataService.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDataServiceApplicationTests {

	private MockMvc mvc;
	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private UserDAL userDAL;

	@Mock
	private UserRepository userRepository;

	@Test
	public void givenCreateUrlTest_shouldSucceed() throws Exception {
		User user = new User();
		user.setUserName("harsha");
		user.setEmail("sriharsh654@gmail.com");
		user.setCreationDate(new Date());

		Assertions.assertEquals(user, userDAL.addNewUser(user));
	}
}

