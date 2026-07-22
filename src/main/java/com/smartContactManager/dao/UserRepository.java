package com.smartContactManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartContactManager.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
