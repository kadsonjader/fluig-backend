package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.Veiculo;
import com.fluig.fluigbackend.model.request.BuscaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoRepositoryImpl implements VeiculoRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public Integer countByVeiculo(BuscaRequest request) {
        Map<String, Object> parameters = new HashMap<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*) from Veiculo v ");
        sql.append("where 1=1");
        appendTxtBusca(request, sql, parameters);

        Query query = em.createQuery(sql.toString());
        parameters.forEach(query::setParameter);
        return ((Long) query.getSingleResult()).intValue();
    }

    @Override
    public List<Veiculo> findPaginated(PageRequest pegeable, BuscaRequest request) {
        Map<String, Object> parameters = new HashMap<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" select v from LinhaTarifa v ");
        sql.append("where 1=1");
        appendTxtBusca(request, sql, parameters);
        sql.append("order by v.cdVeiculo desc");

        Query query = em.createQuery(sql.toString(), Veiculo.class);
        parameters.forEach(query::setParameter);
        if (pegeable != null) {
            query.setFirstResult(pegeable.getPageNumber() * pegeable.getPageSize());
            query.setMaxResults(pegeable.getPageSize());
        }
        return query.getResultList();
    }

    private void appendTxtBusca(BuscaRequest request, StringBuilder sql, Map<String, Object> parameters) {

        Integer cdVeiculo = request.getCdVeiculo();
        if (cdVeiculo != null) {
            sql.append(" and v.cdVeiculo = :cdVeiculo ");
            parameters.put("cdVeiculo", cdVeiculo);
        }
    }
}
