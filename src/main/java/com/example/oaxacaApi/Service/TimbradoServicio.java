package com.example.oaxacaApi.Service;

import java.util.Optional;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;
import com.example.oaxacaApi.Repository.TimbradoRepository;

import java.util.List;

@Service
public class TimbradoServicio {
    @Autowired
    TimbradoRepository timbradoRepository;

    @Autowired
    CapitalHRepository capitalHRepository;

    public Optional<TimbradoEntity> getId(Integer id){
        return timbradoRepository.findById(id);
    }

    // @Query(value = "SELECT n FROM timbrado n WHERE n.idCapitalHumano = ?1", nativeQuery = true)
    public Optional<TimbradoEntity> getIdCapitalHumano(Integer idCapitalHumano){
        Optional <CapitalHEntity> capitalHumano = capitalHRepository.findById(idCapitalHumano);
        CapitalHEntity capitalHumanoID = capitalHumano.get();
        return timbradoRepository.findByCapitalHEntity(capitalHumanoID);
    }
}
