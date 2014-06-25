package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import repository.data.MalhaLogisticaRepositoryDAO;
import repository.data.TrechoRepositoryDAO;
import service.MalhaLogisticaService;
import domain.model.MalhaLogistica;
import domain.model.Trecho;

@Component
public class DefaultMalhaLogisticaService implements MalhaLogisticaService {

    @Autowired
    private MalhaLogisticaRepositoryDAO dao;

    @Autowired
    private TrechoRepositoryDAO trechoDAO;

    /** {@inheritDoc} */
    public MalhaLogistica getOne(Long id) throws Exception {
        return dao.getOne(id);
    }

    /** {@inheritDoc} */
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(MalhaLogistica domain) throws Exception {
        dao.saveAndFlush(domain);

        final Collection<Trecho> trechos = domain.getTrechos();

        if (trechos != null) {
            for (Trecho trecho : trechos) {
                trecho.setMalhaLogistica(domain);
                trechoDAO.save(trecho);
            }

            trechoDAO.flush();
        }
    }

    /** {@inheritDoc} */
    public Collection<MalhaLogistica> findAll() throws Exception {
        return dao.findAll();
    }
}
