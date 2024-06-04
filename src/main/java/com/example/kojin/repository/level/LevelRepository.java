package com.example.kojin.repository.level;

import com.example.kojin.entity.LevelRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LevelRepository implements ILevelRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<LevelRecord> findAll(){
        return jdbcTemplate.query("select * from level;",
                new DataClassRowMapper<>(LevelRecord.class));
    }

}
