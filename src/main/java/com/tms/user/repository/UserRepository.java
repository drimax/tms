package com.tms.user.repository;

import com.tms.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hp on 9/17/2017.
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUserId(String userId);
}

