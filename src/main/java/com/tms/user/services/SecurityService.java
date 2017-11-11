package com.tms.user.services;

/**
 * Created by hp on 9/30/2017.
 */
public interface SecurityService {

    public String findLoggedInUsername();

    public void autologin(String username, String password);

}
