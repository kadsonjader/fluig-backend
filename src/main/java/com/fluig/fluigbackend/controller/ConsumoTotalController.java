package com.fluig.fluigbackend.controller;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.ConsumoTotal;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.service.ConsumoTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumoTotalController {

    @Autowired
    private ConsumoTotalService consumoTotalService;

    @PostMapping("/consumos/veiculos")
    public List<ConsumoTotal> findAllConsumos(@RequestBody BuscaRequest request){
        return consumoTotalService.findAllConsumos(request);
    }
}
