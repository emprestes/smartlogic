package domain.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EntregaTest {

    @Test
    public void criarRotaUmTrechoTest() {
        Entrega domain = new Entrega("A D", 12.0, 1.25);

        domain.criarRota();

        Assert.assertEquals(1, domain.getQuantidadeTrechos());
    }

    @Test
    public void criarRotaDoisTrechosTest() {
        Entrega domain = new Entrega("A B C", 12.0, 1.25);

        domain.criarRota();

        Assert.assertEquals(2, domain.getQuantidadeTrechos());
    }

    @Test
    public void criarRotaVariosTrechosTest() {
        Entrega domain = new Entrega("A B C E D", 12.0, 1.25);

        domain.criarRota();

        Assert.assertEquals(4, domain.getQuantidadeTrechos());
    }
}
