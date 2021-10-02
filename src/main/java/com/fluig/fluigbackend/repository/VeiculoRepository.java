package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>, VeiculoRepositoryCustom {

    Veiculo findByCdVeiculo(Integer cdVeiculo);

}
