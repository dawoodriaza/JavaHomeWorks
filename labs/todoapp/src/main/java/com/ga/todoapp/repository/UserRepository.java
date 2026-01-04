package com.ga.todoapp.repository;

import com.ga.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAddress(String userEmailAddress);
    User findUserByEmailAddress(String userEmailAddress);


}
