package com.fluig.fluigbackend.service;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.ConsumoTotal;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.repository.ConsumoTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class ConsumoTotalService {

    @Autowired
    private ConsumoTotalRepository repository;


    public List<ConsumoTotal> findAllConsumos(BuscaRequest request){
        return calculoConsumo(request);
    }

    public List<ConsumoTotal> calculoConsumo(BuscaRequest request){
        List<ConsumoTotal> consumos = repository.findAllConsumo(request);
        Double vltotalCombustivel = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getNuPrecoGasolina()).sum()).sum();
        double vltotalCidade = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getNuConsumoCidade()).sum()).sum();
        double vltotalRodovia = consumos.stream().mapToDouble(c -> DoubleStream.of(c.getNuConsumoRodovia()).sum()).sum();
        Double vlsomaConsumototal = Double.sum(vltotalCidade,vltotalRodovia);
        Double vlConsumototal = vlsomaConsumototal * vltotalCombustivel;
        consumos.stream().forEach(consumo -> {
            consumo.setVlTotalCombustivel(vltotalCombustivel);
            consumo.setQtTotalGasto(vlConsumototal);
        });
        return consumos;
    }
}
