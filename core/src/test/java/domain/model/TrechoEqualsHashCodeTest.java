package domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class TrechoEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public TrechoEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("A");
        pojo.setDestino("B");
        pojo.setDistancia(10.0);

        return pojo;
    }

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("B");
        pojo.setDestino("D");
        pojo.setDistancia(15.0);

        return pojo;
    }
}