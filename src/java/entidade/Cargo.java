
package entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    
    private String cbo;
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    private DescricaoCargo descricaoCargo;
    
    @ManyToOne
    private Empregador empregador;

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
    }

    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DescricaoCargo getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(DescricaoCargo descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }


    

    public Cargo() {
    }

    public String getCbo() {
        return cbo;
    }

    public Cargo(String cbo, String nome) {
        super();
        this.cbo = cbo;
        this.nome = nome;
 
    }
    
    

    public void setCbo(String cbo) {
        this.cbo = cbo;
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
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TabelaCBO[ id=" + id + " ]";
    }
    
}
