package repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import domain.model.MalhaLogistica;

public interface MalhaLogisticaRepositoryDAO extends JpaRepository<MalhaLogistica, Long> {

    final static String FIND_BY_MALHA_QUERY = "SELECT t01 FROM MalhaLogistica t01 WHERE t01.nome LIKE :nameMalha";

    @Query(FIND_BY_MALHA_QUERY)
    List<MalhaLogistica> findAll(@Param("nameMalha") String nameMalha);
}
