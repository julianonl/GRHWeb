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
import javax.persistence.Temporal;

@Entity
public class Trabalhador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "foto", length = 255, nullable = true)
    private String foto;
    @Column(name = "cpf", unique = true, length = 14, nullable = false)
    private String cpf;
    @Column(name = "email", length = 100, nullable = true)
    private String email;
    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;
   
    @Column(name = "numeroRg", length = 20, nullable = true)
    private String numeroRg;
    @Column(name = "dataExpedicaoRg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataExpedicaoRg;
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
    private Instrucao instrucao;
    @Column(name = "DataDeNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name = "estadoCivil", length = 50, nullable = true)
    private String estadoCivil;
    @Column(name = "sexo", length = 30, nullable = true)
    private String sexo;
    @ManyToOne
    private Nacionalidade nacionalidade;
    @Column(name = "telefoneCelular", length = 30, nullable = true)
    private String telefoneCelular;
    @Column(name = "DataDeCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cep cep;
    @ManyToOne
    private Cargo cargo;
    @Column(name = "dataDeAdmissao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeAdmissao;
    private int horasSemanais;
    private String estatus;
    @ManyToOne
    private Empregador empregador;
    private int dependenteSalarioFamilia;
    private int dependenteIRRF;
    
    @Column(name = "banco", length = 50, nullable = true)
    private String banco;

    @Column(name = "agencia", length = 50, nullable = true)
    private String agencia;

    @Column(name = "operacao", length = 50, nullable = true)
    private String operacao;

    @Column(name = "conta", length = 50, nullable = true)
    private String conta;
    
    @ManyToOne
    private TabelaSalario salario;

    public TabelaSalario getSalario() {
        return salario;
    }

    public void setSalario(TabelaSalario salario) {
        this.salario = salario;
    }
    
    

    public Long getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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


    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public Date getDataExpedicaoRg() {
        return dataExpedicaoRg;
    }

    public void setDataExpedicaoRg(Date dataExpedicaoRg) {
        this.dataExpedicaoRg = dataExpedicaoRg;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public int getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(int horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
    

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
    }

    public int getDependenteSalarioFamilia() {
        return dependenteSalarioFamilia;
    }

    public void setDependenteSalarioFamilia(int dependenteSalarioFamilia) {
        this.dependenteSalarioFamilia = dependenteSalarioFamilia;
    }

    public int getDependenteIRRF() {
        return dependenteIRRF;
    }

    public void setDependenteIRRF(int dependenteIRRF) {
        this.dependenteIRRF = dependenteIRRF;
    }

}
