package com.example.kojin.service.song;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.SearchForm;

import java.util.List;

public interface ISongsService {

    List<SongRecord> findAll();

    List<SongDateRecord> findAllDate();

    List<SongDateRecord> findSong(String key);
}
