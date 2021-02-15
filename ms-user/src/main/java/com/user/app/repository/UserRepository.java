package com.user.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.app.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByEmail(String email);

}
