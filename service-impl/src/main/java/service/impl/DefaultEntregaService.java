package service.impl;

import java.util.List;

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
    public Double calcularCusto(String origem, String destino, Double autonomia, Double valorLitro) throws Exception {
        StringBuffer rota = new StringBuffer(origem);
        List<Trecho> trechos;
        Trecho trecho;

        trechos = trechoDAO.find(origem, destino);

        if (!trechos.isEmpty()) {
            rota.append(' ').append(destino);
        } else {
            String proximo = origem;
            do {
                trechos = trechoDAO.findDistanciaMinima(proximo);
                trecho = trechos.get(0);
                proximo = trecho.getDestino();
                rota.append(' ').append(proximo);
            } while (!destino.equalsIgnoreCase(proximo));
        }

        return calcularCusto(rota.toString(), autonomia, valorLitro);
    }

    @Override
    public Double calcularCusto(String rota, Double autonomia, Double valorLitro) throws Exception {
        return calcularCusto(new Entrega(rota, autonomia, valorLitro));
    }

    /** {@inheritDoc} */
    public Double calcularCusto(Entrega entrega) throws Exception {
        Trecho trecho, proximo;
        double valor = 0.0;
        int totalTrechos = 0;

        entrega.criarRota();
        trecho = proximo = entrega.getTrecho();
        totalTrechos = trecho.getQuantidade();

        do {
            proximo.setDistancia(trechoDAO.findDistancia(proximo.getOrigem(), proximo.getDestino()).get(0));
            if (proximo.isNotUltimo()) {
                proximo = proximo.getProximo();
            }
        } while (--totalTrechos > 0);

        valor = trecho.getDistanciaTotal() / entrega.getAutonomia();

        return valor * entrega.getValorLitro();
    }
}
