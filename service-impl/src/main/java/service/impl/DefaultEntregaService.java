package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.data.TrechoRepositoryDAO;
import service.EntregaService;
import domain.model.Entrega;
import domain.model.Trecho;

@Component
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
        int totalTrechos = 0;

        entrega.criarRota();
        trecho = entrega.getTrecho();
        totalTrechos = trecho.getQuantidade();

        do {
            trecho.setDistancia(trechoDAO.findDistancia(trecho.getOrigem(), trecho.getDestino()).get(0));
            if (trecho.isNotUltimo()) {
                trecho = trecho.getProximo();
            }
        } while (totalTrechos-- > 0);

        valor = trecho.getDistanciaTotal() / entrega.getAutonomia();

        return valor * entrega.getValorLitro();
    }
}
