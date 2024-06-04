package com.example.kojin.repository.genre;

import com.example.kojin.entity.GenreRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository implements IGenreRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<GenreRecord> findAll(){
        return jdbcTemplate.query("select * from genre;",
                new DataClassRowMapper<>(GenreRecord.class));
    }

}
