package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.data.TrechoRepositoryDAO;
import service.EntregaService;
import domain.model.Trecho;

@Component
public class DefaultEntregaService implements EntregaService {

    @Autowired
    private TrechoRepositoryDAO trechoDAO;

    @Override
    public Double calcularCusto(String origem, String destino, Double autonomia, Double valorLitro) throws Exception {
        List<Trecho> trechos;
        Trecho trecho = null;
        double valor = 0.0;

        trechos = trechoDAO.find(origem, destino);

        if (!trechos.isEmpty()) {
            trecho = trechos.get(0);
        } else {
            Trecho proximoTrecho;
            String proximoDestino = origem;
            do {
                trechos = trechoDAO.findDistanciaMinima(proximoDestino);
                if (trecho == null) {
                    trecho = proximoTrecho = trechos.get(0);
                } else {
                    proximoTrecho = trechos.get(0);
                    trecho.setProximo(proximoTrecho);
                }
                proximoDestino = proximoTrecho.getDestino();
            } while (!destino.equalsIgnoreCase(proximoDestino));
        }

        valor = trecho.getDistanciaTotal() / autonomia;

        return valor * valorLitro;
    }
}
