package com.example.oaxacaApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.CapitalHEntity;

public interface CapitalHRepository extends JpaRepository<CapitalHEntity, Integer> {
    List<CapitalHEntity> findDataByStatus(Boolean status);
}
