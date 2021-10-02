package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    Consumo findByCdConsumo(Integer cdConsumo);

    Consumo findByCdVeiculo(Integer cdVeiculo);
}
