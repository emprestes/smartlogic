package domain.model;

import java.util.Collection;
import java.util.TreeSet;

public class MalhaLogistica {

    private String nome;
    private Collection<Trecho> trechos = new TreeSet<>();

    public MalhaLogistica() {
        super();
    }

    public MalhaLogistica(String nome) {
        this();

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(Collection<Trecho> trechos) {
        this.trechos = trechos;
    }
}
