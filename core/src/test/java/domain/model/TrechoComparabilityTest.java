package domain.model;

import junitx.extensions.ComparabilityTestCase;

public class TrechoComparabilityTest extends ComparabilityTestCase {

    public TrechoComparabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable<Trecho> createEqualInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("B");
        pojo.setDestino("C");
        pojo.setDistancia(8.0);

        return pojo;
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable<Trecho> createGreaterInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("C");
        pojo.setDestino("D");
        pojo.setDistancia(20.0);

        return pojo;
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable<Trecho> createLessInstance() throws Exception {
        Trecho pojo = new Trecho();

        pojo.setOrigem("A");
        pojo.setDestino("B");
        pojo.setDistancia(10.0);

        return pojo;
    }
}