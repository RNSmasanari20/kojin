package com.example.kojin.repository.genre;

import com.example.kojin.entity.GenreRecord;

import java.sql.SQLException;
import java.util.List;

public interface IGenreRepository {

    List<GenreRecord> findAll() throws SQLException;
}
