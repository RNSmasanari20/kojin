package com.example.kojin.service.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.form.UserForm;

public interface IUserService {

    UserRecord findUser(LoginForm loginForm);

    UserRecord findUser(int id);

    int updateUser(UserForm userForm);

    int deleteUser(int id);
}
