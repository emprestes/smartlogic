package domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class MalhaLogisticaSerializableTest extends SerializabilityTestCase {

    public MalhaLogisticaSerializableTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        MalhaLogistica pojo = new MalhaLogistica();

        pojo.setNome("A");

        return pojo;
    }
}