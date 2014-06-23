package service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import repository.data.MalhaLogisticaRepositoryDAO;
import service.MalhaLogisticaService;
import domain.model.MalhaLogistica;

@Resource
public class DefaultMalhaLogisticaService implements MalhaLogisticaService {

    @Autowired
    private MalhaLogisticaRepositoryDAO dao;

    /** {@inheritDoc} */
    public MalhaLogistica getOne(Long id) throws Exception {
        return dao.getOne(id);
    }

    /** {@inheritDoc} */
    public void save(MalhaLogistica domain) throws Exception {
        dao.saveAndFlush(domain);
    }

    /** {@inheritDoc} */
    public Collection<MalhaLogistica> findAll() throws Exception {
        return dao.findAll();
    }
}
