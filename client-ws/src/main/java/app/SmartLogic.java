package app;

import webservice.impl.Entrega;
import webservice.impl.EntregaEndpointWS;
import webservice.impl.MalhaLogistica;
import webservice.impl.MalhaLogisticaEndpointWS;
import webservice.impl.MalhaLogistica_Service;
import webservice.impl.Trecho;

public class SmartLogic {

    public static void main(String[] args) {
        try {
            Entrega entregaService = new Entrega();
            EntregaEndpointWS entregaWS = entregaService.getEntregaEndpointWSPort();
            MalhaLogistica_Service malhaService = new MalhaLogistica_Service();
            MalhaLogisticaEndpointWS malhaWS = malhaService.getMalhaLogisticaEndpointWSPort();
            MalhaLogistica domain = new MalhaLogistica("Malha Teste");

            domain.getTrechos().add(new Trecho("A", "B", 10d));
            domain.getTrechos().add(new Trecho("B", "D", 15d));
            domain.getTrechos().add(new Trecho("A", "C", 20d));
            domain.getTrechos().add(new Trecho("C", "D", 30d));
            domain.getTrechos().add(new Trecho("B", "E", 50d));
            domain.getTrechos().add(new Trecho("D", "E", 30d));

            malhaWS.save(domain);

            System.out.println("Malha teste salva com 6 trechos.");

            double valor = entregaWS.calcularCusto("A", "D", 10d, 2.5);

            System.out.printf("Valor de custo: %s\n", valor);
        } catch (Exception cause) {
            cause.printStackTrace();
        }
    }
}
