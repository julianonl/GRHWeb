
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Nacionalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    
      @Column(name = "codigoNacionalidade", length = 8, nullable = true)
    private String codigoNacionalidade;
      
       @Column(name = "paisNacionalidade", length = 8, nullable = true)
    private String paisNacionalidade;

    public String getCodigoNacionalidade() {
        return codigoNacionalidade;
    }

    public void setCodigoNacionalidade(String codigoNacionalidade) {
        this.codigoNacionalidade = codigoNacionalidade;
    }

    public String getPaisNacionalidade() {
        return paisNacionalidade;
    }

    public void setPaisNacionalidade(String paisNacionalidade) {
        this.paisNacionalidade = paisNacionalidade;
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
        if (!(object instanceof Nacionalidade)) {
            return false;
        }
        Nacionalidade other = (Nacionalidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Nacionalidade[ id=" + id + " ]";
    }
    
}
