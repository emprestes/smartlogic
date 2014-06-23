package service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import repository.data.TrechoRepositoryDAO;
import service.EntregaService;
import domain.model.Entrega;
import domain.model.Trecho;

@Resource
public class DefaultEntregaService implements EntregaService {

    @Autowired
    private TrechoRepositoryDAO trechoDAO;

    /** {@inheritDoc} */
    public Trecho calcularCusto(Entrega entrega) throws Exception {
        Trecho trecho;

        entrega.criarRota();
        trecho = entrega.getTrecho();

        return trecho;
    }

}
