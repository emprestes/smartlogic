package repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import repository.TrechoDAO;
import domain.model.Trecho;

@Repository
public interface TrechoRepositoryDAO extends TrechoDAO, JpaRepository<Trecho, Long> {

    final static String FIND_BY_MALHA_QUERY = "SELECT t02 FROM MalhaLogistica t01 "
            + "INNER JOIN T01.trechos t02 WHERE t01.nome = :nameMalha";

    @Override
    @Query(FIND_BY_MALHA_QUERY)
    List<Trecho> findAll(@Param("nameMalha") String nameMalha);
}
