package com.fluig.fluigbackend.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BuscaRequest {

    private Integer cdVeiculo;
    private Integer cdConsumo;
    private Integer txtBusca;
    private String campoOrdenacao;
    private String direcaoOrdenacao;
}
