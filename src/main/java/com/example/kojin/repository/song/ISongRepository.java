package com.example.kojin.repository.song;

import com.example.kojin.entity.EditRecord;
import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.EditForm;
import com.example.kojin.form.InsertForm;
import com.example.kojin.form.SearchForm;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;
import java.util.List;

public interface ISongRepository {

    List<SongRecord> findAll() throws SQLException;

    List<SongDateRecord> findAllDate() throws SQLException;

    List<SongDateRecord> findSong(String key) throws SQLException;

    int insertSong(InsertForm insertForm) throws SQLException, DuplicateKeyException;

    EditRecord findById(int id) throws SQLException;

    int updateSong(EditForm editForm) throws SQLException, DuplicateKeyException;

    int deleteSong(int id) throws SQLException;
}
