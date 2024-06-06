package com.example.kojin.repository.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import com.example.kojin.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class UserRepository implements IUserRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public UserRecord findUser(LoginForm loginForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginForm.getLoginId());
        param.addValue("password", loginForm.getPassword());
        var list = jdbcTemplate.query("select * from users " +
                "where login_id = :loginId and password = :password;", param,
                new DataClassRowMapper<>(UserRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public UserRecord findUser(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("select * from users " +
                        "where id = :id;", param,
                new DataClassRowMapper<>(UserRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int updateUser(UserForm userForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", userForm.getId());
        param.addValue("login_id", userForm.getLogin_id());
        param.addValue("name", userForm.getName());
        param.addValue("password", userForm.getPassword());
        return jdbcTemplate.update("update users " +
                "set name = :name " +
                ", login_id = :login_id " +
                ", password = :password " +
                "where id = :id;",param);
    }

    @Override
    public int deleteUser(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        return jdbcTemplate.update("delete from users where id = :id",param);
    }
}
