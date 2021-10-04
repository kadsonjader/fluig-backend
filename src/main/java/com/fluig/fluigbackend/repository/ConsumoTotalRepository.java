package com.fluig.fluigbackend.repository;

import com.fluig.fluigbackend.model.ConsumoTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoTotalRepository extends JpaRepository<ConsumoTotal, Integer>, ConsumoTotalRepositoryCustom {
}
