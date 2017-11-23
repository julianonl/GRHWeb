package entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
public class Cnpj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cnpj", length = 20, nullable = false, unique = true)
    private String cnpj;
    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "abertura", nullable = true)
    private Date abertura;
    @Column(name = "razaoSocial", length = 250, nullable = false)
    private String razaoSocial;
    @Column(name = "nomeFantasia", length = 250, nullable = true)
    private String nomeFantasia;
    @Column(name = "numeroCnae", length = 20, nullable = false)
    private String numeroCnae;
    @Column(name = "descricaoCnae", length = 250, nullable = true)
    private String descricaoCnae;
    @Column(name = "naturezaJuridica", length = 250, nullable = false)
    private String naturezaJuridica;
    @Column(name = "Senha", length = 40)
    private String senha;
    @Column(name = "Permissao", length = 36)
    private String permissao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cep cep;
    @Column(name = "telefone", length = 30, nullable = true)
    private String telefone;
    @Column(name = "situacaoAtivaInativa", length = 20, nullable = true)
    private String situacaoAtivaInativa;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataSituacao")
    private Date dataSituacao;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
    

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNumeroCnae() {
        return numeroCnae;
    }

    public void setNumeroCnae(String numeroCnae) {
        this.numeroCnae = numeroCnae;
    }

    public String getDescricaoCnae() {
        return descricaoCnae;
    }

    public void setDescricaoCnae(String descricaoCnae) {
        this.descricaoCnae = descricaoCnae;
    }

    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    
    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSituacaoAtivaInativa() {
        return situacaoAtivaInativa;
    }

    public void setSituacaoAtivaInativa(String situacaoAtivaInativa) {
        this.situacaoAtivaInativa = situacaoAtivaInativa;
    }

    public Date getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(Date dataSituacao) {
        this.dataSituacao = dataSituacao;
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
        if (!(object instanceof Cnpj)) {
            return false;
        }
        Cnpj other = (Cnpj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Cnpj[ id=" + id + " ]";
    }

}
