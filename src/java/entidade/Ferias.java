package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Ferias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "inicioPeriodo", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioPeriodo;

    @Column(name = "fimPeriodo", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fimPeriodo;

    @Column(name = "avisoFerias", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date avisoFerias;

    @Column(name = "inicioFerias", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioFerias;

    @Column(name = "terminoFerias", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date terminoFerias;

    private int numeroDeDias;
    private int numeroDeFaltas;
    private Double valorFerias;
    private Double tercoFerias;
    private Double inssRetidoFerias;
    private Double inssEmpresaFerias;
    private Double iRRFFerias;
    @ManyToOne
    private Trabalhador trabalhador;

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }
    
    

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getFimPeriodo() {
        return fimPeriodo;
    }

    public void setFimPeriodo(Date fimPeriodo) {
        this.fimPeriodo = fimPeriodo;
    }

    public Date getAvisoFerias() {
        return avisoFerias;
    }

    public void setAvisoFerias(Date avisoFerias) {
        this.avisoFerias = avisoFerias;
    }

    public Date getInicioFerias() {
        return inicioFerias;
    }

    public void setInicioFerias(Date inicioFerias) {
        this.inicioFerias = inicioFerias;
    }

    public Date getTerminoFerias() {
        return terminoFerias;
    }

    public void setTerminoFerias(Date terminoFerias) {
        this.terminoFerias = terminoFerias;
    }

    public int getNumeroDeDias() {
        return numeroDeDias;
    }

    public void setNumeroDeDias(int numeroDeDias) {
        this.numeroDeDias = numeroDeDias;
    }

    public int getNumeroDeFaltas() {
        return numeroDeFaltas;
    }

    public void setNumeroDeFaltas(int numeroDeFaltas) {
        this.numeroDeFaltas = numeroDeFaltas;
    }

    public Double getValorFerias() {
        return valorFerias;
    }

    public void setValorFerias(Double valorFerias) {
        this.valorFerias = valorFerias;
    }

    public Double getTercoFerias() {
        return tercoFerias;
    }

    public void setTercoFerias(Double tercoFerias) {
        this.tercoFerias = tercoFerias;
    }

    public Double getInssRetidoFerias() {
        return inssRetidoFerias;
    }

    public void setInssRetidoFerias(Double inssRetidoFerias) {
        this.inssRetidoFerias = inssRetidoFerias;
    }

    public Double getInssEmpresaFerias() {
        return inssEmpresaFerias;
    }

    public void setInssEmpresaFerias(Double inssEmpresaFerias) {
        this.inssEmpresaFerias = inssEmpresaFerias;
    }

    public Double getiRRFFerias() {
        return iRRFFerias;
    }

    public void setiRRFFerias(Double iRRFFerias) {
        this.iRRFFerias = iRRFFerias;
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
        if (!(object instanceof Ferias)) {
            return false;
        }
        Ferias other = (Ferias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Ferias[ id=" + id + " ]";
    }

}
