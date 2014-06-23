package service;

import domain.model.Entrega;
import domain.model.Trecho;

public interface EntregaService {

    Trecho calcularCusto(Entrega entrega) throws Exception;
}
