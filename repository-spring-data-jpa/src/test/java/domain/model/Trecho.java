package domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trecho")
public class Trecho {

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

    @ManyToOne
    @JoinColumn(name = "id_malha", nullable = false)
    private MalhaLogistica malhaLogistica;

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
}
