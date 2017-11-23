package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Empregador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Cnpj cnpj;
    @Column(name = "responsavelNome", length = 150, nullable = false)
    private String responsavelNome;
    @Column(name = "responsavelCPF", length = 16, nullable = false)
    private String responsavelCPF;
    @Column(name = "responsavelEmail", length = 150, nullable = true)
    private String responsavelEmail;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cep cep;
    @Column(name = "DataDeCadastro", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    @Column(name = "logoMarca", nullable = true)
    private String logoMarca;
    
    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public String getResponsavelEmail() {
        return responsavelEmail;
    }

    public void setResponsavelEmail(String responsavelEmail) {
        this.responsavelEmail = responsavelEmail;
    }

    public void setResponsavelNome(String responsavelNome) {
        this.responsavelNome = responsavelNome;
    }

    public String getResponsavelCPF() {
        return responsavelCPF;
    }

    public void setResponsavelCPF(String responsavelCPF) {
        this.responsavelCPF = responsavelCPF;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public String getLogoMarca() {
        return logoMarca;
    }

    public void setLogoMarca(String logoMarca) {
        this.logoMarca = logoMarca;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
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
        if (!(object instanceof Empregador)) {
            return false;
        }
        Empregador other = (Empregador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Empregador[ id=" + id + " ]";
    }

}
