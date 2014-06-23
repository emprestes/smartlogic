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

    @Override
    public Double calcularCusto(Double autonomia, Double valorLitro, String rota) throws Exception {
        return calcularCusto(new Entrega(rota, autonomia, valorLitro));
    }

    /** {@inheritDoc} */
    public Double calcularCusto(Entrega entrega) throws Exception {
        Trecho trecho;
        double valor = 0.0;
        double distancia = 0.0;

        entrega.criarRota();
        trecho = entrega.getTrecho();

        while (!trecho.isUltimo()) {
            trecho = trechoDAO.findDistancia(trecho.getOrigem(), trecho.getDestino()).get(0);
            distancia += trecho.getDistancia();
        }

        valor = distancia / entrega.getAutonomia();

        return valor * entrega.getValorLitro();
    }
}
