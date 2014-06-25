package repository.data;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.model.MalhaLogistica;

import repository.test.AbstractDAOTest;

public class MalhaLogisticaRepositoryDAOTest extends AbstractDAOTest {

    @Autowired
    private MalhaLogisticaRepositoryDAO dao;

    @Override
    protected String[] getTestFiles() {
        return new String[] { "META-INF/sample-data.xml" };
    }

    @Test
    public void getOneTest() {
        MalhaLogistica domain = null;

        domain = dao.getOne(1L);

        Assert.assertNotNull(domain);
    }

    @Test
    public void getTechosTest() {
        MalhaLogistica domain = null;
        Collection<?> trechos;

        domain = dao.getOne(1L);
        trechos = domain.getTrechos();

        Assert.assertNotNull(trechos);
    }

    @Test
    public void saveAndFlushTest() {
        MalhaLogistica domain = new MalhaLogistica();

        domain.setNome("Nova Malha");

        domain = dao.saveAndFlush(domain);

        Assert.assertNotNull(domain);
        Assert.assertNotNull(domain.getId());
    }
}
