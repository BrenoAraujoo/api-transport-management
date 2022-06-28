package com.shipping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
