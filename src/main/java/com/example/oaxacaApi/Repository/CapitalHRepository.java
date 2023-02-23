package com.example.oaxacaApi.Repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.CapitalHEntity;

public interface CapitalHRepository extends JpaRepository<CapitalHEntity, Integer> {
    List<CapitalHEntity> findDataByStatus(Boolean status);
    List<CapitalHEntity> findByFechaPago(Date fechaPago);
}
