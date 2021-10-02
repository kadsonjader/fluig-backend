package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Veiculo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface VeiculoRepositoryCustom {

    Integer countByVeiculo(BuscaRequest request);
    List<Veiculo> findPaginated(PageRequest pegeable, BuscaRequest request);
}
