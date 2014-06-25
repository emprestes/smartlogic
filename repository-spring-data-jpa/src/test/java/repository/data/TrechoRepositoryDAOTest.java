package repository.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import repository.test.AbstractDAOTest;
import domain.model.MalhaLogistica;
import domain.model.Trecho;

public class TrechoRepositoryDAOTest extends AbstractDAOTest {

    @Autowired
    private TrechoRepositoryDAO dao;

    @Override
    protected String[] getTestFiles() {
        return new String[] { "META-INF/sample-data.xml" };
    }

    @Test
    public void getOneTest() {
        Trecho domain = null;

        domain = dao.getOne(1L);

        Assert.assertNotNull(domain);
    }

    @Test
    public void findDistanciaTest() {
        List<Double> trechos;

        trechos = dao.findDistancia("A", "B");

        Assert.assertEquals(1, trechos.size());
        Assert.assertNotNull(trechos.get(0));
    }

    @Test
    public void saveAndFlushTest() {
        Trecho domain = new Trecho();
        MalhaLogistica malha = new MalhaLogistica();

        malha.setId(1L);
        malha.setNome("Nova Malha");

        domain.setOrigem("D");
        domain.setDestino("E");
        domain.setDistancia(23.7);
        domain.setMalhaLogistica(malha);

        domain = dao.saveAndFlush(domain);

        Assert.assertNotNull(domain);
        Assert.assertNotNull(domain.getId());
    }

    @Test
    public void findDistanciaMinimaTest() {
        List<Trecho> results = dao.findDistanciaMinima("A");

        Assert.assertEquals(Double.valueOf(10.0), results.get(0).getDistancia());
    }

    @Test
    public void findTest() {
        List<Trecho> results = dao.find("A", "B");

        Assert.assertEquals(1, results.size());
    }
}
