package webservice.impl;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import service.MalhaLogisticaService;
import domain.model.MalhaLogistica;

@WebService(serviceName = "MalhaLogistica")
public class MalhaLogisticaEndpointWS {

    @Autowired
    private MalhaLogisticaService service;

    @WebMethod
    public void save(MalhaLogistica domain) throws Exception {
        service.save(domain);
    }

    @WebMethod
    public Collection<MalhaLogistica> findAll() throws Exception {
        return service.findAll();
    }
}
