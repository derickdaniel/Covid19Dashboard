package com.covid19.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.covid19.demo.config.WebSecurityConfig;
import com.covid19.demo.service.IUserManagementService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private UserDetailsService userDetailSvc;
  
  @MockBean
  private UserDetails userDetails;
  
  @MockBean
  private WebSecurityConfig securityConfig;
  
  @MockBean
  private IUserManagementService userSvc;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Ignore
  @Test
  public void showRegistrationForm() throws Exception {
    final RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("localhost:8282/registration").contentType(MediaType.APPLICATION_JSON);
    final MvcResult result =
        mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
    Assert.assertEquals(200, result.getResponse().getStatus());
  }
  
}
