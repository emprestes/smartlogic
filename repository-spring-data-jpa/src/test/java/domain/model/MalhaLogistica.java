package domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "malha")
public class MalhaLogistica {

    @SequenceGenerator(initialValue = 1, name = "IdGenerator", sequenceName = "malha_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    @Column(name = "id_malha", columnDefinition = "integer")
    private Long id;

    @Column(name = "nm_malha")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "malhaLogistica")
    private Set<Trecho> trechos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(Set<Trecho> trechos) {
        this.trechos = trechos;
    }
}
