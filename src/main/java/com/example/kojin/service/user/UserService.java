package com.example.kojin.service.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.form.UserForm;
import com.example.kojin.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    @Override
    public UserRecord findUser(int id){
        try {
            return userRepository.findUser(id);
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public int updateUser(UserForm userForm){
        try {
            return userRepository.updateUser(userForm);
        }catch (SQLException e){
            return 0;
        }catch (DuplicateKeyException e){
            return -1;
        }
    }

    @Override
    public int deleteUser(int id){
        try {
            return userRepository.deleteUser(id);
        }catch (SQLException e){
            return 0;
        }
    }
}
