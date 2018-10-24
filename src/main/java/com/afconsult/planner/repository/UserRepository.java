package com.afconsult.planner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @UserRepository repository class for User.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByName(String name);
}
