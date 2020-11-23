package com.covid19.demo.controller;

import com.covid19.demo.entity.User;
import com.covid19.demo.repository.IUserRepository;
import com.covid19.demo.service.IUserManagementService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Dashboard Controller to handle the requests related to dashboard services
 */
@Controller
@RequestMapping("/")
public class DashboardController {
  
  @Autowired
  private IUserManagementService userManagementService;
  
  @Autowired
  private IUserRepository userRepository;
  
  @GetMapping("/layout")
  public ModelAndView dashboard() throws IOException {
    ModelAndView mav = new ModelAndView("layout");
    UserDetails loggedInUser =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDetails = userRepository.findByEmail(loggedInUser.getUsername()).get();
    userManagementService.getCovid19Data(mav);
    mav.addObject("user", userDetails);
    return mav;
  }
  
  @GetMapping("/districtData")
  public ModelAndView districtData() throws IOException {
    ModelAndView mav = new ModelAndView("districtData");
    UserDetails loggedInUser =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDetails = userRepository.findByEmail(loggedInUser.getUsername()).get();
    userManagementService.getCovid19Data(mav);
    mav.addObject("user", userDetails);
    return mav;
  }
  
}
