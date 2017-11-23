
package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Juliano
 */
@Entity
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    
    
    private Double salario;
    
  
    private Double totalDeProventos;
    private Double totalDeDesconto;
    private Double totalLiquido;
    private Double fgtsRetido;
    private Double InssRetido;
    private Double inssValorDevido;
    private Double irrf;
    @ManyToOne
    private MesReferencia mesReferencia;
    @ManyToOne
    private Trabalhador trabalhador;

    public Double getTotalDeProventos() {
        return totalDeProventos;
    }

    public void setTotalDeProventos(Double totalDeProventos) {
        this.totalDeProventos = totalDeProventos;
    }

    public Double getTotalDeDesconto() {
        return totalDeDesconto;
    }

    public void setTotalDeDesconto(Double totalDeDesconto) {
        this.totalDeDesconto = totalDeDesconto;
    }

    public Double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(Double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public Double getFgtsRetido() {
        return fgtsRetido;
    }

    public void setFgtsRetido(Double fgtsRetido) {
        this.fgtsRetido = fgtsRetido;
    }

    public Double getInssRetido() {
        return InssRetido;
    }

    public void setInssRetido(Double InssRetido) {
        this.InssRetido = InssRetido;
    }

    public Double getInssValorDevido() {
        return inssValorDevido;
    }

    public void setInssValorDevido(Double inssValorDevido) {
        this.inssValorDevido = inssValorDevido;
    }

    public Double getIrrf() {
        return irrf;
    }

    public void setIrrf(Double irrf) {
        this.irrf = irrf;
    }

    public MesReferencia getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(MesReferencia mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Pagamento[ id=" + id + " ]";
    }
    
}
