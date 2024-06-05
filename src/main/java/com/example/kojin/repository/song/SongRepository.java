package com.example.kojin.repository.song;

import com.example.kojin.entity.EditRecord;
import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.EditForm;
import com.example.kojin.form.InsertForm;
import com.example.kojin.form.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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

    @Override
    public int insertSong(InsertForm insertForm){
        var param = new MapSqlParameterSource();
        param.addValue("songName",insertForm.getSong());
        param.addValue("songId",insertForm.getSongId());
        param.addValue("genreId",insertForm.getId());
        return jdbcTemplate.update("insert into songs " +
                "(name, song_id, genre_id) " +
                "values " +
                "(:songName, :songId , :genreId);",param);
    }

    @Override
    public EditRecord findById(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        var list = jdbcTemplate.query("select id, name, song_id, genre_id from songs " +
                "where id =:id;",
                param, new DataClassRowMapper<>(EditRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int updateSong(EditForm editForm){
        var param = new MapSqlParameterSource();
        param.addValue("id",editForm.getId());
        param.addValue("name",editForm.getName());
        param.addValue("genreId",editForm.getGenreId());
        param.addValue("songId",editForm.getSongId());
        return jdbcTemplate.update("update songs " +
                "set " +
                "name = :name, " +
                "song_id = :songId, " +
                "genre_id = :genreId " +
                "where id = :id;",
                param);
    }

    @Override
    public int deleteSong(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.update("delete from songs " +
                "where id = :id;", param);
    }
}
