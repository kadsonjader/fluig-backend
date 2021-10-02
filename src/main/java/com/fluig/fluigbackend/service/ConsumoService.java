package com.fluig.fluigbackend.service;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    private Consumo findByCdConsumo(Integer cdConsumo){
        return repository.findByCdConsumo(cdConsumo);
    }

    private Consumo findByCdVeiculo(Integer cdVeiculo){
        return repository.findByCdVeiculo(cdVeiculo);
    }


}
