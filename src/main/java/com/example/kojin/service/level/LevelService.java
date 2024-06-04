package com.example.kojin.service.level;

import com.example.kojin.entity.LevelRecord;
import com.example.kojin.repository.level.ILevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LevelService implements ILevelService{

    @Autowired
    ILevelRepository levelRepository;

    @Override
    public List<LevelRecord> findAll(){
        try {
            return levelRepository.findAll();
        }catch (SQLException e){
            return null;
        }
    }
}
