package com.example.oaxacaApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;

public interface TimbradoRepository extends JpaRepository<TimbradoEntity, Integer>{    
    List<TimbradoEntity> findByCapitalHEntity(CapitalHEntity idCapitalHumano);
    List<TimbradoEntity> findDataByStatus(Boolean status);
    List<TimbradoEntity> findDataByCapitalHEntityAndStatus(CapitalHEntity idCapitalHumano, Boolean status);
}
