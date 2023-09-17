package com.evan.springbootmvcsecurityhibernatemysql.repository;

import com.evan.springbootmvcsecurityhibernatemysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
