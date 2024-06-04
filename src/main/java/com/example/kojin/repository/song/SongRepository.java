package com.example.kojin.repository.song;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository implements ISongRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<SongRecord> findAll(){
        return jdbcTemplate.query("select * from songs;",
                new DataClassRowMapper<>(SongRecord.class));
    }

    @Override
    public List<SongDateRecord> findAllDate(){
        return jdbcTemplate.query("select songs.id, name, song_id, genre_id, genre from songs " +
                "inner join genre " +
                "on songs.genre_id = genre.id;",
                new DataClassRowMapper<>(SongDateRecord.class));
    }

    @Override
    public List<SongDateRecord> findSong(String key){
        var param = new MapSqlParameterSource();
        String send = "%" + key + "%";
        param.addValue("songName",send);
        return jdbcTemplate.query("select songs.id, name, song_id, genre_id, genre from songs " +
                        "inner join genre " +
                        "on songs.genre_id = genre.id " +
                        "where name like :songName;",
                param, new DataClassRowMapper<>(SongDateRecord.class));
    }
}
