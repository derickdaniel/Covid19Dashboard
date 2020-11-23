package com.covid19.demo.service.impl;

import com.covid19.demo.entity.User;
import com.covid19.demo.exception.UserAlreadyRegisteredException;
import com.covid19.demo.json.model.CovidData;
import com.covid19.demo.json.model.CovidTotalCountData;
import com.covid19.demo.repository.IUserRepository;
import com.covid19.demo.service.IUserManagementService;
import com.covid19.demo.util.ApiCallsUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserManagementServiceImpl implements IUserManagementService {
  
  @Value("${get_covid_total_count}")
  private String covidTotalCountUrl;
  
  @Value("get_covid_state_data")
  private String covidStateDataUrl;
  
  @Autowired
  private IUserRepository userRepository;
  
  @Autowired
  private ApiCallsUtil apiCallsUtil;
  
  @Override
  public User registerUser(User user) throws UserAlreadyRegisteredException {
    Optional<User> userEntity = userRepository.findByEmail(user.getEmail());
    if (userEntity.isPresent()) {
      throw new UserAlreadyRegisteredException("User is already registered with email provided");
    }
    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    user = userRepository.save(user);
    return user;
  }
  
  @Override
  public void getCovid19Data(ModelAndView mav) throws IOException {
    CovidTotalCountData covidTotalCountData = apiCallsUtil.getCovidTotalCountData();
    List<CovidData> covidStateDataList = apiCallsUtil.getCovidStateData();
    mav.addObject("covidTotal", covidTotalCountData);
    mav.addObject("covidStateDataList", covidStateDataList);
  }
  
}
