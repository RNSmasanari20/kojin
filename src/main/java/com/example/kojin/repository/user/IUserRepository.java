package com.example.kojin.repository.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;

import java.sql.SQLException;

public interface IUserRepository {

    UserRecord findUser(LoginForm loginForm) throws SQLException;
}
