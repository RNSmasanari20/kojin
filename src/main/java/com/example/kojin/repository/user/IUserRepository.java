package com.example.kojin.repository.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.form.UserForm;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

public interface IUserRepository {

    UserRecord findUser(LoginForm loginForm) throws SQLException;

    UserRecord findUser(int id) throws SQLException;

    int updateUser(UserForm userForm) throws SQLException, DuplicateKeyException;

    int deleteUser(int id) throws SQLException;
}
