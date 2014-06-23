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
    public Double calcularCusto(String rota, Double autonomia, Double valorLitro) throws Exception {
        return calcularCusto(new Entrega(rota, autonomia, valorLitro));
    }

    /** {@inheritDoc} */
    public Double calcularCusto(Entrega entrega) throws Exception {
        Trecho trecho;
        double valor = 0.0;
        double distancia = 0.0;

        entrega.criarRota();
        trecho = entrega.getTrecho();

        do {
            trecho.setDistancia(trechoDAO.findDistancia(trecho.getOrigem(), trecho.getDestino()).get(0));
            if (!trecho.isUltimo()) {
                trecho = trecho.getProximo();
            }
        } while (!trecho.isUltimo());

        valor = trecho.getDistanciaRota() / entrega.getAutonomia();

        return valor * entrega.getValorLitro();
    }
}
