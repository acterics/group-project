package com.groupproject.userservice.repository;

import com.groupproject.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rick on 03.12.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

