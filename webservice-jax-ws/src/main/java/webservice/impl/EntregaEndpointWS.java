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
    public Double calcularCusto(String rota, Double valorLitro, Double distancia) throws Exception {
        return service.calcularCusto(rota, valorLitro, distancia);
    }
}
