package com.example.kojin.repository.level;

import com.example.kojin.entity.LevelRecord;

import java.sql.SQLException;
import java.util.List;

public interface ILevelRepository {

    List<LevelRecord> findAll() throws SQLException;
}
