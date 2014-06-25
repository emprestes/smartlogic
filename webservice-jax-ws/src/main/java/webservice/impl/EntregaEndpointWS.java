package webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import service.EntregaService;

@WebService(serviceName = "Entrega")
public class EntregaEndpointWS {

    @Autowired
    private EntregaService service;

    @WebMethod
    public Double calcularCusto(String origem, String destino, Double autonomia, Double valorLitro) throws Exception {
        return service.calcularCusto(origem, destino, autonomia, valorLitro);
    }
}
