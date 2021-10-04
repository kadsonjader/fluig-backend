package com.fluig.fluigbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EFLUIGCONSUMO")
@Getter @Setter
public class Consumo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdConsumo;
    private Integer cdVeiculo;
    private Double nuPrecoGasolina;
    private Double nuKmCidade;
    private Double nuKmRodovia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdVeiculo", updatable = false, insertable = false, nullable = true)
    private Veiculo veiculo;
}
