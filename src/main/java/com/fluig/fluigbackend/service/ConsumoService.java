package com.fluig.fluigbackend.service;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.dto.ConsumoDTO;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.repository.ConsumoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    public Consumo findByCdConsumo(Integer cdConsumo){
        return repository.findByCdConsumo(cdConsumo);
    }

    public Consumo findByCdVeiculo(Integer cdVeiculo){
        return repository.findByCdVeiculo(cdVeiculo);
    }

    public Consumo saveConsumos(ConsumoDTO dto){
        Consumo consumo = new Consumo();
        BeanUtils.copyProperties(dto,consumo);
        consumo.setVeiculo(null);
        repository.save(consumo);
        return consumo;
    }

}
