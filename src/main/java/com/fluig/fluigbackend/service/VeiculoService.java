package com.fluig.fluigbackend.service;

import com.fluig.fluigbackend.model.Veiculo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Veiculo findByCdveiculo(Integer cdVeiculo){
        return repository.findByCdVeiculo(cdVeiculo);
    }

    public Page<Veiculo> findAllVeiculos(Integer page, Integer size, BuscaRequest request){
        PageRequest pageable =  PageRequest.of(page, size);
        Integer count = repository.countByVeiculo(request);
        List<Veiculo> veiculos = repository.findPaginated(pageable, request);
        return new PageImpl<Veiculo>(veiculos, pageable, count);
    }

    public Veiculo saveVeiculos(Veiculo veiculo){
        repository.save(veiculo);
        return veiculo;
    }
}
