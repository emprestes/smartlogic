package domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class EntregaSerializableTest extends SerializabilityTestCase {

    public EntregaSerializableTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        Entrega pojo = new Entrega();

        pojo.setRota("A B D");
        pojo.setAutonomia(10.0);
        pojo.setValorLitro(2.5);

        return pojo;
    }
}