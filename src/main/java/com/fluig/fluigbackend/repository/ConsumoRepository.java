package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer>, ConsumoRespositoryCustom {

    Consumo findByCdConsumo(Integer cdConsumo);

    Consumo findByCdVeiculo(Integer cdVeiculo);
}
