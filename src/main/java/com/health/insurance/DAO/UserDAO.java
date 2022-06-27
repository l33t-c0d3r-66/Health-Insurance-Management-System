package com.health.insurance.DAO;

import com.health.insurance.beans.User;

public interface UserDAO {
    boolean saveUser(User user);
    User getUser(String userName, String password);
}
