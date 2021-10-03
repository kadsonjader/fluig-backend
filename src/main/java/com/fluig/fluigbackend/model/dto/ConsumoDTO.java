package com.fluig.fluigbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsumoDTO {

    private Integer cdConsumo;
    private Integer cdVeiculo;
    private Double nuPrecoGasolina;
    private Double nuKmCidade;
    private Double nuKmRodovia;

}
