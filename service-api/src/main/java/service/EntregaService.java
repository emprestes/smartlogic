package service;

import domain.model.Entrega;

public interface EntregaService {

    Double calcularCusto(Double autonomia, Double valorLitro, String rota) throws Exception;

    Double calcularCusto(Double autonomia, Double valorLitro, String... rota) throws Exception;

    Double calcularCusto(Entrega entrega) throws Exception;
}
