package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.model.ConsumoTotal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoTotalRepositoryCustom {

    List<ConsumoTotal> findAllConsumo(BuscaRequest request);
}
