package domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class EntregaEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public EntregaEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
        Entrega pojo = new Entrega();

        pojo.setRota("A B D");
        pojo.setAutonomia(10.0);
        pojo.setValorLitro(2.5);

        return pojo;
    }

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        Entrega pojo = new Entrega();

        pojo.setRota("A C D");
        pojo.setAutonomia(8.0);
        pojo.setValorLitro(3.5);

        return pojo;
    }
}