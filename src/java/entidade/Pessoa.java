package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cadastroPessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true, length = 14, nullable = false)
    private String cpf;
    @Column(name = "email", length = 100, nullable = true)
    private String email;
    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;
    @Column(name = "endereco", length = 150, nullable = true)
    private String endereco;
    @Column(name = "numeroEndereco", length = 20, nullable = true)
    private String numeroEndereco;

    @Column(name = "bairro", length = 150, nullable = true)
    private String bairro;
    
    @Column(name = "numeroRg", length = 20, nullable = true)
    private String numeroRg;

    @Column(name = "DataExpediçãoRg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataExpediçãoRg;

    @Column(name = "orgaoExpedidorRg", length = 8, nullable = true)
    private String orgaoExpedidorRg;

    @Column(name = "ufCTPS", length = 5, nullable = true)
    private String ufCTPS;

    @Column(name = "numeroCTPS", length = 20, nullable = true)
    private String numeroCTPS;

    @Column(name = "serieCTPS", length = 20, nullable = true)
    private String serieCTPS;

    @Column(name = "DataEmissaoCTPS", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataEmissaoCTPS;

    @Column(name = "ufRg", length = 5, nullable = true)
    private String ufRg;

    @Column(name = "pis", length = 15, nullable = true)
    private String pis;


    @ManyToOne
    private BancoPagador bancoPagador;


    @ManyToOne
    private Instrucao instrucao;

    @Column(name = "DataDeNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;


    @ManyToOne
    private EstadoCivil estadoCivil;

    @Column(name = "sexo", length = 30, nullable = true)
    private String sexo;


    @ManyToOne
    private Nacionalidade nacionalidade;

    @Column(name = "telefoneCelular", length = 30, nullable = true)
    private String telefoneCelular;

    @Column(name = "DataDeCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    @Column(name = "CEP")
    @ManyToOne
    private Cep cep;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public Date getDataExpediçãoRg() {
        return DataExpediçãoRg;
    }

    public void setDataExpediçãoRg(Date DataExpediçãoRg) {
        this.DataExpediçãoRg = DataExpediçãoRg;
    }

    public String getOrgaoExpedidorRg() {
        return orgaoExpedidorRg;
    }

    public void setOrgaoExpedidorRg(String orgaoExpedidorRg) {
        this.orgaoExpedidorRg = orgaoExpedidorRg;
    }

    public String getUfCTPS() {
        return ufCTPS;
    }

    public void setUfCTPS(String ufCTPS) {
        this.ufCTPS = ufCTPS;
    }

    public String getNumeroCTPS() {
        return numeroCTPS;
    }

    public void setNumeroCTPS(String numeroCTPS) {
        this.numeroCTPS = numeroCTPS;
    }

    public String getSerieCTPS() {
        return serieCTPS;
    }

    public void setSerieCTPS(String serieCTPS) {
        this.serieCTPS = serieCTPS;
    }

    public Date getDataEmissaoCTPS() {
        return DataEmissaoCTPS;
    }

    public void setDataEmissaoCTPS(Date DataEmissaoCTPS) {
        this.DataEmissaoCTPS = DataEmissaoCTPS;
    }

    public String getUfRg() {
        return ufRg;
    }

    public void setUfRg(String ufRg) {
        this.ufRg = ufRg;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public BancoPagador getBancoPagador() {
        return bancoPagador;
    }

    public void setBancoPagador(BancoPagador bancoPagador) {
        this.bancoPagador = bancoPagador;
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }


    
    

}
