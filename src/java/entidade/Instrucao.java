package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigoInstrucao", length = 5, nullable = true)
    private String codigoInstrucao;

    @Column(name = "descricaoInstrucao", length = 5, nullable = true)
    private String descricaoInstrucao;

    public String getCodigoInstrucao() {
        return codigoInstrucao;
    }

    public void setCodigoInstrucao(String codigoInstrucao) {
        this.codigoInstrucao = codigoInstrucao;
    }

    public String getDescricaoInstrucao() {
        return descricaoInstrucao;
    }

    public void setDescricaoInstrucao(String descricaoInstrucao) {
        this.descricaoInstrucao = descricaoInstrucao;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrucao)) {
            return false;
        }
        Instrucao other = (Instrucao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Instrucao[ id=" + id + " ]";
    }

}
