package com.example.oaxacaApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.TimbradoRepository;

@Service
public class TimbradoServicio {
    @Autowired
    TimbradoRepository timbradoRepository;

    public Optional<TimbradoEntity> getId(Integer id){
        return timbradoRepository.findById(id);
    }

    public Optional<TimbradoEntity> getIdCapitalHumano(Integer idCapitalHumano){
        return timbradoRepository.findBycapitalHEntity(idCapitalHumano);
    }
}
