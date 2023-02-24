package com.example.oaxacaApi.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;

import net.bytebuddy.asm.Advice.Local;

@Service
public class CapitalHService {
    @Autowired
    CapitalHRepository capitalHRepository;

    public List<CapitalHEntity> getDataByStatus(Boolean status){
        List<CapitalHEntity> capitalHumano = capitalHRepository.findDataByStatus(status);
        // CapitalHEntity capitalHumanoStatus = capitalHumano.get();
        return capitalHumano;
    }

    /* public List<CapitalHEntity> geyDataByFechaInicio(String fechaInicio) throws ParseException {
        LocalDate fechaInicioLD = LocalDate.parse(fechaInicio);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicio(fechaInicioLD);
        return capitalHumano;
    }

    public List<CapitalHEntity> geyDataByFechaFin(String fechaFin) throws ParseException {
        LocalDate fechaFinLD = LocalDate.parse(fechaFin);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaFin(fechaFinLD);
        return capitalHumano;
    } */

    public List<CapitalHEntity> getDataByFechaPago(String fechaPago) throws ParseException {        
        LocalDate fechaPagoLD = LocalDate.parse(fechaPago);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaPago(fechaPagoLD);
        return capitalHumano;
    }


    /* public List<CapitalHEntity> getDataByFechaInicioAndFechaFin(String fechaInicio, String fechaFin) throws ParseException {
        LocalDate fechaInicioLD = LocalDate.parse(fechaInicio);
        LocalDate fechaFinLD = LocalDate.parse(fechaFin);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicioAndFechaFin(fechaInicioLD, fechaFinLD);
        return capitalHumano;
    } */
}
