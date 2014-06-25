package repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import domain.model.Trecho;

@Repository
public interface TrechoRepositoryDAO extends JpaRepository<Trecho, Long> {

    final static String FIND_BY_MALHA_QUERY = "SELECT t02 FROM MalhaLogistica t01 "
            + "INNER JOIN T01.trechos t02 WHERE t01.nome = :nameMalha";

    final static String FIND_BY_DISTANCIA_QUERY = "SELECT t01.distancia FROM Trecho t01 "
            + "WHERE t01.origem = :origem AND t01.destino = :destino";

    final static String FIND_BY_TERCHO_QUERY = "SELECT t01 FROM Trecho t01 "
            + "WHERE t01.origem = :origem AND t01.destino = :destino";

    final static String FIND_MIN_DISTANCIA_QUERY = "SELECT t01 FROM Trecho t01 "
            + "WHERE t01.origem = :origem ORDER BY t01.distancia ASC";

    @Query(FIND_BY_MALHA_QUERY)
    List<Trecho> findAll(@Param("nameMalha") String nameMalha);

    @Query(FIND_BY_DISTANCIA_QUERY)
    List<Double> findDistancia(@Param("origem") String origem, @Param("destino") String destino);

    @Query(FIND_MIN_DISTANCIA_QUERY)
    List<Trecho> findDistanciaMinima(@Param("origem") String origem);

    @Query(FIND_BY_TERCHO_QUERY)
    List<Trecho> find(@Param("origem") String origem, @Param("destino") String destino);
}
