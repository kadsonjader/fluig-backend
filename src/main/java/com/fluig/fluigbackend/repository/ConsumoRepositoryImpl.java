package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Consumo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ConsumoRepositoryImpl implements ConsumoRespositoryCustom{

    @Autowired
    private EntityManager em;

    @Override
    public List<Consumo> findAllConsumo(BuscaRequest request) {
        StringBuilder hql = new StringBuilder();

        hql.append("select v.nmVeiculo, v.nmMarca, v.nmModelo, v.dtFabricacao, v.nuConsumoCidade, v.nuConsumoRodovia,");
        hql.append(" con.nuPrecoGasolina, con.nuKmCidade, con.nuKmRodovia ");
        hql.append("from Consumo con join Veiculo v");

        Query query = em.createQuery(hql.toString());

        List<Consumo> consumos = query.getResultList();
        return consumos;
    }
}
