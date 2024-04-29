package com.javastudies.login_system.repository;

import com.javastudies.login_system.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {


}
