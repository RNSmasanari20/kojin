package com.example.kojin.service.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserRecord findUser(LoginForm loginForm){
        try {
            return userRepository.findUser(loginForm);
        }catch (SQLException e){
            return null;
        }

    }
}
