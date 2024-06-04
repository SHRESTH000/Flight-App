package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	@Query(nativeQuery = true,value ="select * from user_data where username= :username" )
	public User getUserByUserName(String username);  

}
