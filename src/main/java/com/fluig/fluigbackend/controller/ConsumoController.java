package com.fluig.fluigbackend.controller;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.dto.ConsumoDTO;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/consumos")
    public Consumo saveConsumos(@RequestBody ConsumoDTO dto){
        return consumoService.saveConsumos(dto);
    }

}
