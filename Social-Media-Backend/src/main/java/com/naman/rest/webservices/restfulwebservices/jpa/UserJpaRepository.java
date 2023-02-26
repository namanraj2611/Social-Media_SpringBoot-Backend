package com.naman.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.rest.webservices.restfulwebservices.user.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
