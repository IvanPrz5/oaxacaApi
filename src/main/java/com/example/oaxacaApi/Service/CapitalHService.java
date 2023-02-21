package com.example.oaxacaApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;

@Service
public class CapitalHService {
    @Autowired
    CapitalHRepository capitalHRepository;

    public List<CapitalHEntity> getDataByStatus(Boolean status){
        List<CapitalHEntity> capitalHumano = capitalHRepository.findDataByStatus(status);
        // CapitalHEntity capitalHumanoStatus = capitalHumano.get();
        return capitalHumano;
    }
}
