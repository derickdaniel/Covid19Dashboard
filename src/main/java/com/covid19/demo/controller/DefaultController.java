package com.covid19.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
  
  @GetMapping("/")
  public String home1() {
    return "index";
  }
  
  @GetMapping("/home")
  public String home() {
    return "/index";
  }
  
  @GetMapping("/dashboard")
  public String dashboard() {
    return "/dashboard";
  }
  
  @GetMapping("/login")
  public String login() {
    return "/login";
  }
  
  @GetMapping("/logout")
  public String logout() {
    return "/logout";
  }
  
  @GetMapping("/403")
  public String error403() {
    return "/error/403";
  }
  
}