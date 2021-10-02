package com.fluig.fluigbackend.controller;

import com.fluig.fluigbackend.model.Veiculo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos/{cdVeiculo}")
    public Veiculo findByCdveiculo(@PathVariable Integer cdVeiculo){
        return veiculoService.findByCdveiculo(cdVeiculo);
    }

    @PostMapping("/veiculos/pages/{page}/{size}")
    public Page<Veiculo> findAllVeiculos(@PathVariable Integer page, @PathVariable Integer size, @RequestBody BuscaRequest request){
        return veiculoService.findAllVeiculos(page, size, request);
    }

    @PostMapping("/Veiculos")
    public Veiculo saveVeiculos(@RequestBody Veiculo veiculo){
        return veiculoService.saveVeiculos(veiculo);
    }
}
