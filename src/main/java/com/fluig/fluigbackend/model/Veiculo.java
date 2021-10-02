package com.fluig.fluigbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EFLUIGVEICULOS")
@Getter @Setter
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdVeiculo;

    private String nmVeiculo;
    private String nmMarca;
    private String nmModelo;
    private Date dtFabricacao;
    private Double nuConsumoCidade;
    private Double nuConsumoRodovia;

}
