package domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class MalhaLogistica implements Serializable {

    private static final long serialVersionUID = 5926955875984905810L;

    @SequenceGenerator(initialValue = 1, name = "IdGenerator", sequenceName = "malha_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    @Column(name = "id_malha", columnDefinition = "integer")
    private Long id;

    @Column(name = "nm_malha")
    private String nome;

    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE }, mappedBy = "malhaLogistica")
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
