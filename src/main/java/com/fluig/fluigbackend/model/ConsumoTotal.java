package com.fluig.fluigbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
public class ConsumoTotal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdConsumoTotal;

    private String nmVeiculo;
    private String nmMarca;
    private String nmModelo;
    private Date dtFabricacao;
    private Double nuConsumoCidade;
    private Double nuConsumoRodovia;
    private Double nuPrecoGasolina;
    private Double nuKmCidade;
    private Double nuKmRodovia;

    private Double qtTotalGasto;
    private Double vlTotalCombustivel;

    public ConsumoTotal(String nmVeiculo,
                        String nmMarca,
                        String nmModelo,
                        Date dtFabricacao,
                        Double nuConsumoCidade,
                        Double nuConsumoRodovia,
                        Double nuPrecoGasolina,
                        Double nuKmCidade,
                        Double nuKmRodovia){

        this.nmVeiculo = nmVeiculo;
        this.nmMarca = nmMarca;
        this.nmModelo = nmModelo;
        this.dtFabricacao = dtFabricacao;
        this.nuConsumoCidade = nuConsumoCidade;
        this.nuConsumoRodovia = nuConsumoRodovia;
        this.nuPrecoGasolina = nuPrecoGasolina;
        this.nuKmCidade = nuKmCidade;
        this.nuKmRodovia = nuKmRodovia;

    }

    public ConsumoTotal() {

    }
}
