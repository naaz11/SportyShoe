package com.simplilearn.repository;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	User findByUsername(String Username);
}
