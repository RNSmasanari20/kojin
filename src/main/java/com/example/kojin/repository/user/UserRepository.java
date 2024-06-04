package com.example.kojin.repository.user;

import com.example.kojin.entity.UserRecord;
import com.example.kojin.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
