package domain.model;

import java.io.Serializable;

public class Entrega implements Serializable {

    private static final long serialVersionUID = 8370434011510895872L;

    private String rota;
    private Double autonomia;
    private Double valorLitro;
    private Trecho trecho;

    public Entrega() {
        super();
    }

    public Entrega(String rota, Double autonomia, Double valorLitro) {
        super();

        this.rota = rota;
        this.autonomia = autonomia;
        this.valorLitro = valorLitro;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public Double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }

    public Double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(Double valorLitro) {
        this.valorLitro = valorLitro;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public void setTrecho(Trecho trecho) {
        this.trecho = trecho;
    }

    public int getQuantidadeTrechos() {
        return getTrecho() == null ? 0 : getTrecho().getQuantidade();
    }

    public void criarRota() {
        String[] rota = this.rota != null ? this.rota.split(" "): new String[0];

        for (int i = 0; i < rota.length; i++) {
            if (i == (rota.length - 1)) {
                break;
            } else if (i == 0) {
                setTrecho(new Trecho(rota[i], rota[i + 1]));
            } else {
                getTrecho().setProximo(new Trecho(rota[i], rota[i + 1]));
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autonomia == null) ? 0 : autonomia.hashCode());
        result = prime * result + ((rota == null) ? 0 : rota.hashCode());
        result = prime * result + ((valorLitro == null) ? 0 : valorLitro.hashCode());
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
        if (!(obj instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) obj;
        if (autonomia == null) {
            if (other.autonomia != null) {
                return false;
            }
        } else if (!autonomia.equals(other.autonomia)) {
            return false;
        }
        if (rota == null) {
            if (other.rota != null) {
                return false;
            }
        } else if (!rota.equals(other.rota)) {
            return false;
        }
        if (valorLitro == null) {
            if (other.valorLitro != null) {
                return false;
            }
        } else if (!valorLitro.equals(other.valorLitro)) {
            return false;
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Entrega [rota=");
        builder.append(rota);
        builder.append(", autonomia=");
        builder.append(autonomia);
        builder.append(", valorLitro=");
        builder.append(valorLitro);
        builder.append("]");
        return builder.toString();
    }
}
