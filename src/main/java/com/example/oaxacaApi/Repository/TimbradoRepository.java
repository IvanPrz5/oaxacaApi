package com.example.oaxacaApi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.TimbradoEntity;

public interface TimbradoRepository extends JpaRepository<TimbradoEntity, Integer>{

    Optional<TimbradoEntity> findBycapitalHEntity(Integer idCapitalHumano);
}
