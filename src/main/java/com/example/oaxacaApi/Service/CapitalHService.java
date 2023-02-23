package com.example.oaxacaApi.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public List<CapitalHEntity> getDataByFechaPago(String fechaPago){
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaPago(fechaPago);
        return capitalHumano;
    }
}
