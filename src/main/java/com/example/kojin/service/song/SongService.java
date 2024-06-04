package com.example.kojin.service.song;

import com.example.kojin.entity.SongDateRecord;
import com.example.kojin.entity.SongRecord;
import com.example.kojin.form.SearchForm;
import com.example.kojin.repository.song.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SongService implements ISongsService{

    @Autowired
    ISongRepository songRepository;

    @Override
    public List<SongRecord> findAll(){
        try {
            return songRepository.findAll();
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public List<SongDateRecord> findAllDate(){
        try {
            return songRepository.findAllDate();
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public List<SongDateRecord> findSong(String key){
        try {
            return songRepository.findSong(key);
        }catch (SQLException e){
            return null;
        }
    }
}


