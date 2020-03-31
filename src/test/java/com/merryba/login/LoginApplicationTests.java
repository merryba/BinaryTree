package com.merryba.login;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.merryba.login.controller.*;
import com.merryba.login.model.*;
import com.merryba.login.service.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LoginApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@InjectMocks
    LoginController loginController;
     
    @Mock
    UserService userservice;
     
    @Test
    public void testAddUser() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(userservice.save(any(User.class))).thenReturn(true);
         
        User user = new User();
        user.setEmail("testing@gmail.com");
        user.setPassword( "admin123");
        ResponseEntity<Object> responseEntity = userservice.saveUser(user);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
     
}
