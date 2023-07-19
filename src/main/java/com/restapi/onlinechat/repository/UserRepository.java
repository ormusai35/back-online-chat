package com.restapi.onlinechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.onlinechat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	List<User> findByUserName(String userName);
	
}
