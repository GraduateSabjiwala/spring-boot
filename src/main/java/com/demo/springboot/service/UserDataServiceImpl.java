package com.demo.springboot.service;

import com.demo.springboot.model.UserData;
import com.demo.springboot.repository.UserDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    UserDataRepo userDataRepo;
    private final RestTemplate restTemplate;

    public UserDataServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData addUser(){
        UserData userData = new UserData();
        try {
            log.info("Inside UserDataServiceImpl");
            userData = restTemplate.exchange("https://randomuser.me/api/", HttpMethod.GET, null, new ParameterizedTypeReference<UserData>() {
            }).getBody();
            log.info("userData : {}", userData);
        }catch (Exception e){
            log.error("Exception occurred {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        return userDataRepo.addUser(userData);
    }
}
