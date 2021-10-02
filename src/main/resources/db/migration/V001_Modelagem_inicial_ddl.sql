/*
 - identificador: V001__modelagem_inicial-ddl.sql
 - autor: Kadson Jader
 - data: 01/10/2021
*/
CREATE TABLE EFLUIGVEICULOS
(
    cdveiculo        NUMERIC(10),
    nmveiculo        VARCHAR(255),
    nmmarca          VARCHAR(255),
    nmmodelo         VARCHAR(255),
    dtfabricacao     TIMESTAMP,
    nuconsumocidade  NUMERIC(13,2),
    nuconsumorodovia NUMERIC(13,2),
    CONSTRAINT pkveiculo PRIMARY KEY (cdveiculo)
);

CREATE TABLE EFLUIGCONSUMO
(
    cdconsumo       NUMERIC(10),
    cdveiculo       NUMERIC(10),
    nuprecogasolina NUMERIC(13, 2) NOT NULL,
    nukmcidade      NUMERIC(13,2)    NOT NULL,
    nukmrodovia     NUMERIC(13,2)    NOT NULL,
    CONSTRAINT pkconsumo PRIMARY KEY (cdconsumo)
);


ALTER TABLE EFLUIGCONSUMO
    ADD CONSTRAINT fkconsumo_veiculo
        FOREIGN KEY (cdveiculo)
            REFERENCES EFLUIGVEICULOS (cdveiculo);