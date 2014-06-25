package service;

import java.util.Collection;

import domain.model.MalhaLogistica;

public interface MalhaLogisticaService {

    void save(MalhaLogistica domain) throws Exception;

    MalhaLogistica getOne(Long id) throws Exception;

    Collection<MalhaLogistica> findAll() throws Exception;
}
