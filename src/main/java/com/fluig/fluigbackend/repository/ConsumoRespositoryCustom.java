package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.request.BuscaRequest;

import java.util.List;

public interface ConsumoRespositoryCustom {

    List<Consumo> findAllConsumo(BuscaRequest request);

}
