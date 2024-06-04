package com.example.kojin.service.genre;

import com.example.kojin.entity.GenreRecord;
import com.example.kojin.repository.genre.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GenreService implements IGenreService{

    @Autowired
    IGenreRepository genreRepository;

    @Override
    public List<GenreRecord> findAll(){
        try {
            return genreRepository.findAll();
        }catch (SQLException e){
            return null;
        }
    }
}
