package com.tms.user.services;

import com.tms.user.model.User;

/**
 * Created by hp on 9/17/2017.
 */
public interface UserService {

    public void save(User user);

    public User findByUsername(String username);
}
