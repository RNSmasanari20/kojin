package com.example.kojin.service.song;

import com.example.kojin.entity.EditRecord;
import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.EditForm;
import com.example.kojin.form.InsertForm;
import com.example.kojin.form.SearchForm;

import java.util.List;

public interface ISongsService {

    List<SongRecord> findAll();

    List<SongDateRecord> findAllDate();

    List<SongDateRecord> findSong(String key);

    int insertSong(InsertForm insertForm);

    EditRecord findById(int id);

    int updateSong(EditForm editForm);

    int deleteSong(int id);
}
