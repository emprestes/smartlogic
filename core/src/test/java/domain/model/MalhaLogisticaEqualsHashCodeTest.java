package domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class MalhaLogisticaEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public MalhaLogisticaEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
        MalhaLogistica pojo = new MalhaLogistica();

        pojo.setNome("A");

        return pojo;
    }

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        MalhaLogistica pojo = new MalhaLogistica();

        pojo.setNome("B");

        return pojo;
    }
}