package com.covid19.demo.controller;

import com.covid19.demo.entity.User;
import com.covid19.demo.exception.UserAlreadyRegisteredException;
import com.covid19.demo.service.IUserManagementService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/*
 * User Controller to handle the requests related to user account login services
 */
@Controller
@RequestMapping("/")
public class UserController {
  
  @Autowired
  private IUserManagementService userManagementService;
  
  @GetMapping("/registration")
  public ModelAndView showRegistrationForm(WebRequest request, final ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    return new ModelAndView("registration", model);
  }
  
  @PostMapping("/registration")
  public ModelAndView registerUserAccount(@ModelAttribute("user") User user,
      final ModelMap model,
      HttpServletRequest request, Errors errors) {
    try {
      user = userManagementService.registerUser(user);
    } catch (UserAlreadyRegisteredException e) {
      model.addAttribute("alreadyRegisteredMessage", e.getMessage());
      return new ModelAndView("registration", model);
    }
    model.clear();
    model.addAttribute("user", new User());
    model.addAttribute("registrationSuccess", "User is registered succesfully.");
    return new ModelAndView("registration", model);
  }
  
  @GetMapping("/login.html")
  public String showLogin(WebRequest request, Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "/login.html";
  }
  
}
