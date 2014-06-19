package domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

public class MalhaLogistica implements Serializable {

    private static final long serialVersionUID = -1628207881226490697L;

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

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MalhaLogistica)) {
            return false;
        }
        MalhaLogistica other = (MalhaLogistica) obj;
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MalhaLogistica [nome=");
        builder.append(nome);
        builder.append(", trechos=");
        builder.append(trechos.size());
        builder.append("]");
        return builder.toString();
    }
}
