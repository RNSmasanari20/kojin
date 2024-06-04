package com.example.kojin.service.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;

public interface IUserService {

    UserRecord findUser(LoginForm loginForm);
}
