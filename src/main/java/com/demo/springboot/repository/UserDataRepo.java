package com.demo.springboot.repository;

import com.demo.springboot.model.UserData;

public interface UserDataRepo {

    UserData addUser(UserData userData);
}
