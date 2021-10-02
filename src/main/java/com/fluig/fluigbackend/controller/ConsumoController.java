package com.fluig.fluigbackend.controller;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;

    @GetMapping("/consumos/{cdConsumo}")
    public Consumo findCdConsumo(@PathVariable Integer cdConsumo){
        return consumoService.findByCdConsumo(cdConsumo);
    }
    @GetMapping("/consumos/{cdVeiculo}")
    public Consumo findByCdVeiculo(@PathVariable Integer cdVeiculo){
        return consumoService.findByCdVeiculo(cdVeiculo);
    }
}
