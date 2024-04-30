package com.javastudies.login_system.service;

import com.javastudies.login_system.model.UserDtls;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

}
