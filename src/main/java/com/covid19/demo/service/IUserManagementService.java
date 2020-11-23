package com.covid19.demo.service;

import com.covid19.demo.entity.User;
import com.covid19.demo.exception.UserAlreadyRegisteredException;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface IUserManagementService {
  
  public User registerUser(User user) throws UserAlreadyRegisteredException;
  
  public void getCovid19Data(ModelAndView mav) throws IOException;
  
}
