package com.example.kojin.repository.song;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.SearchForm;

import java.sql.SQLException;
import java.util.List;

public interface ISongRepository {

    List<SongRecord> findAll() throws SQLException;

    List<SongDateRecord> findAllDate() throws SQLException;

    List<SongDateRecord> findSong(String key) throws SQLException;

}
