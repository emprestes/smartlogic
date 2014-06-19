package repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import repository.MalhaLogisticaDAO;
import domain.model.MalhaLogistica;

@Repository
public interface MalhaLogisticaRepositoryDAO extends MalhaLogisticaDAO, JpaRepository<MalhaLogistica, Long> {

    final static String FIND_BY_MALHA_QUERY = "SELECT t02 FROM MalhaLogistica t01 WHERE t01.nome LIKE :nameMalha";

    @Override
    @Query(FIND_BY_MALHA_QUERY)
    List<MalhaLogistica> findAll(@Param("nameMalha") String nameMalha);
}
