package domain.model;

import java.io.Serializable;

public class Trecho implements Serializable, Comparable<Trecho> {

    private static final long serialVersionUID = -6121495642429670167L;

    private String origem;
    private String destino;
    private Double distancia;
    private Trecho proximo;

    public Trecho() {
        super();
    }

    public Trecho(String origem, String destino, Double distancia) {
        this();

        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Trecho getProximo() {
        return proximo;
    }

    public void setProxima(Trecho proximo) {
        this.proximo = proximo;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
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

        if (!(obj instanceof Trecho)) {
            return false;
        }

        Trecho other = (Trecho) obj;

        if (origem == null) {
            if (other.origem != null) {
                return false;
            }
        } else if (!origem.equals(other.origem)) {
            return false;
        }

        if (destino == null) {
            if (other.destino != null) {
                return false;
            }
        } else if (!destino.equals(other.destino)) {
            return false;
        }

        if (distancia == null) {
            if (other.distancia != null) {
                return false;
            }
        } else if (!distancia.equals(other.distancia)) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Trecho o) {
        int comp = origem == null ? 0 : origem.compareToIgnoreCase(o.origem);

        if (comp == 0 && distancia != null) {
            comp = distancia.compareTo(o.distancia);
        }

        if (comp == 0 && destino != null) {
            comp = destino.compareToIgnoreCase(o.destino);
        }

        return comp;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rota [origem=");
        builder.append(origem);
        builder.append(", destino=");
        builder.append(destino);
        builder.append(", distancia=");
        builder.append(distancia);
        builder.append("]");
        return builder.toString();
    }
}
