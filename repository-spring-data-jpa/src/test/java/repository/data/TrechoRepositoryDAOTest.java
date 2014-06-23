package repository.data;

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
}
