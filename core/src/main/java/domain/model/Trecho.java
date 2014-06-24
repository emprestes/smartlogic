package domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "trecho")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trecho", propOrder = {
    "destino",
    "distancia",
    "id",
    "origem",
    "proximo"
})
public class Trecho implements Serializable, Comparable<Trecho> {

    private static final long serialVersionUID = -3040772213752613287L;

    @SequenceGenerator(initialValue = 1, name = "IdGenerator", sequenceName = "trecho_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    @Column(name = "id_trecho", columnDefinition = "integer")
    private Long id;

    @Column(name = "nm_origem")
    private String origem;

    @Column(name = "nm_destino")
    private String destino;

    @Column(name = "vl_distancia", columnDefinition = "decimal")
    private Double distancia;

    @Transient
    private Trecho proximo;

    @ManyToOne
    @JoinColumn(name = "id_malha", nullable = false)
    @XmlTransient
    private MalhaLogistica malhaLogistica;

    public Trecho() {
        super();
    }

    public Trecho(String origem, String destino) {
        this(origem, destino, null);
    }

    public Trecho(String origem, String destino, Double distancia) {
        this();

        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MalhaLogistica getMalhaLogistica() {
        return malhaLogistica;
    }

    public void setMalhaLogistica(MalhaLogistica malhaLogistica) {
        this.malhaLogistica = malhaLogistica;
    }

    public Trecho getProximo() {
        return proximo;
    }

    public void setProximo(Trecho proximo) {
        if (isUltimo()) {
            this.proximo = proximo;
        } else {
            this.proximo.setProximo(proximo);
        }
    }

    public boolean isUltimo() {
        return proximo == null;
    }

    public boolean isNotUltimo() {
        return !isUltimo();
    }

    public Integer getQuantidade() {
        if (isUltimo()) {
            return 1;
        }

        return 1 + proximo.getQuantidade();
    }

    public Double getDistanciaTotal() {
        if (isUltimo()) {
            return getDistancia();
        }

        return getDistancia() + proximo.getDistanciaTotal();
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
