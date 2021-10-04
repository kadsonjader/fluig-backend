package com.fluig.fluigbackend.repository;


import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import com.fluig.fluigbackend.model.ConsumoTotal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class ConsumoTotalRepositoryImpl implements ConsumoTotalRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<ConsumoTotal> findAllConsumo(BuscaRequest request) {
        Map<String, Object> parameters = new HashMap<>();

        StringBuilder hql = new StringBuilder();

        hql.append("SELECT v.NM_VEICULO , v.NM_MARCA , v.NM_MODELO , v.DT_FABRICACAO , v.NU_CONSUMO_CIDADE , v.NU_CONSUMO_RODOVIA , con.NU_PRECO_GASOLINA , con.NU_KM_CIDADE , con.NU_KM_RODOVIA  FROM EFLUIGCONSUMO  con, EFLUIGVEICULOS v WHERE v.CD_VEICULO = con.CD_VEICULO ");

        Query query = em.createNativeQuery(hql.toString());
        parameters.forEach(query::setParameter);

        List<Object[]> resultList = query.getResultList();
        List<ConsumoTotal> result = new ArrayList<>();
        resultList.stream().forEach(obj -> {
            String nmVeiculo = obj[0] != null ? (String) obj[0] : null;
            String nmMarca = obj[1] != null ? (String) obj[1] : null;
            String nmModelo = obj[2] != null ? (String) obj[2] : null;
            Date dtFabricacao = obj[3] != null ? (Date) obj[3] : null;
            Double nuConsumoCidade = obj[4] != null ? (Double) obj[4] : null;
            Double nuConsumoRodovia = obj[5] != null ? (Double) obj[5] : null;
            Double nuPrecoGasolina = obj[6] != null ? (Double) obj[6] : null;
            Double nuKmCidade = obj[7] != null ? (Double) obj[7] : null;
            Double nuKmRodovia = obj[8] != null ? (Double) obj[8] : null;
            ConsumoTotal total = new ConsumoTotal(nmVeiculo, nmMarca, nmModelo, dtFabricacao,
                    nuConsumoCidade, nuConsumoRodovia, nuPrecoGasolina, nuKmCidade, nuKmRodovia);
            result.add(total);
        });

        return result;
    }
}
