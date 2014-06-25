package domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class TrechoSerializableTest extends SerializabilityTestCase {

    public TrechoSerializableTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("A");
        pojo.setDestino("D");
        pojo.setDistancia(10.0);

        return pojo;
    }
}