package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Dependente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "nomeDependente", length = 50, nullable = true)
    private String nomeDependente;

    @Column(name = "tipoDependente", length = 50, nullable = true)
    private TipoDependente tipoDependente;

    @Column(name = "idadeLimiteIRRF", nullable = true)
    private int idadeLimiteIRRF;

    @Column(name = "cpfDependente", length = 15, nullable = true)
    private String cpfDependente;

    @Column(name = "rgDependente", length = 15, nullable = true)
    private String rgDependente;

    @Column(name = "DataDeNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;

    @Column(name = "estadoCivil", length = 50, nullable = true)
    private String estadoCivil;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public TipoDependente getTipoDependente() {
        return tipoDependente;
    }

    public void setTipoDependente(TipoDependente tipoDependente) {
        this.tipoDependente = tipoDependente;
    }

    public int getIdadeLimiteIRRF() {
        return idadeLimiteIRRF;
    }

    public void setIdadeLimiteIRRF(int idadeLimiteIRRF) {
        this.idadeLimiteIRRF = idadeLimiteIRRF;
    }

    public String getCpfDependente() {
        return cpfDependente;
    }

    public void setCpfDependente(String cpfDependente) {
        this.cpfDependente = cpfDependente;
    }

    public String getRgDependente() {
        return rgDependente;
    }

    public void setRgDependente(String rgDependente) {
        this.rgDependente = rgDependente;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
        if (!(object instanceof Dependente)) {
            return false;
        }
        Dependente other = (Dependente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Dependente[ id=" + id + " ]";
    }

}
