package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    Consumo findByCdConsumo(Integer cdConsumo);

    Consumo findByCdVeiculo(Integer cdVeiculo);

    @Query(value = "SELECT v.NM_VEICULO , v.NM_MARCA , v.NM_MODELO , v.DT_FABRICACAO , v.NU_CONSUMO_CIDADE , v.NU_CONSUMO_RODOVIA , con.NU_PRECO_GASOLINA , con.NU_KM_CIDADE , con.NU_KM_RODOVIA  FROM EFLUIGCONSUMO con, EFLUIGVEICULOS v WHERE v.CD_VEICULO = con.CD_VEICULO ", nativeQuery = true)
    List<Consumo> findConsumos();
}
