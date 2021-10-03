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
        consumo.setQtTotalGasto(null);
        consumo.setVlTotalCombustivel(null);
        repository.save(consumo);
        return consumo;
    }

    public List<Consumo> findAllConsumos(BuscaRequest request){
        List<Consumo> consumos = repository.findAllConsumo(request);
        Double vltotalCombustivel = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getNuPrecoGasolina()).sum()).sum();
        double vltotalCidade = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getVeiculo().getNuConsumoCidade()).sum()).sum();
        double vltotalRodovia = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getVeiculo().getNuConsumoRodovia()).sum()).sum();
        Double vlConsumototal = Double.sum(vltotalCidade,vltotalRodovia);
        consumos.stream().forEach(consumo -> {
            consumo.setVlTotalCombustivel(vltotalCombustivel);
            consumo.setQtTotalGasto(vlConsumototal);
        });
        return consumos;
    }
}
