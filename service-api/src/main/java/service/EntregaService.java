package service;

import domain.model.Entrega;

public interface EntregaService {

    Double calcularCusto(String rota, Double autonomia, Double valorLitro) throws Exception;

    Double calcularCusto(Entrega entrega) throws Exception;
}
