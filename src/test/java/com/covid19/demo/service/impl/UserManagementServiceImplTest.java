package com.covid19.demo.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.covid19.demo.entity.User;
import com.covid19.demo.exception.UserAlreadyRegisteredException;
import com.covid19.demo.json.model.CovidTotalCountData;
import com.covid19.demo.repository.IUserRepository;
import com.covid19.demo.util.ApiCallsUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
public class UserManagementServiceImplTest {
  
  @InjectMocks
  private UserManagementServiceImpl svc;
  
  @Mock
  private IUserRepository repository;
  
  @Mock
  private ApiCallsUtil apiCallsUtil;
  
  @Test
  public void registerUserTest() throws UserAlreadyRegisteredException {
    User user = User.builder().email("test@mail.com").password("password").build();
    Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
    Mockito.when(repository.save(Mockito.any())).thenReturn(user);
    User result = svc.registerUser(user);
    assertEquals(result.getEmail(), user.getEmail());
  }
  
  @Test(expected = UserAlreadyRegisteredException.class)
  public void registerUserTest_existingUser() throws UserAlreadyRegisteredException {
    User user = User.builder().email("test@mail.com").password("password").build();
    Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(user));
    Mockito.when(repository.save(Mockito.any())).thenReturn(user);
    svc.registerUser(user);
  }
  
  @Test
  public void getCovid19DataTest() throws IOException {
    Mockito.when(apiCallsUtil.getCovidTotalCountData())
        .thenReturn(CovidTotalCountData.builder().build());
    Mockito.when(apiCallsUtil.getCovidStateData()).thenReturn(new ArrayList<>());
    ModelAndView mav = new ModelAndView();
    svc.getCovid19Data(mav);
    assertNotNull(mav.getModel().get("covidTotal"));
    assertNotNull(mav.getModel().get("covidStateDataList"));
  }
  
}
