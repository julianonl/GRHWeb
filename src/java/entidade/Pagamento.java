package entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    private String descricaoPag1;
    private String descricaoPag2;
    private String descricaoPag3;
    private double valorPag1;
    private double valorPag2;
    private double valorPag3;
    private String descricaoDesc1;
    private String descricaoDesc2;
    private String descricaoDesc3;
    private double valorDesc1;
    private double valorDesc2;
    private double valorDesc3;
    
    private int refVal1;
    private int refVal2;
    private int refVal3;
    
     private int refDesc1;
     private int refDesc2;
     private int refDesc3;

    private Double totalDeProventos;
    private Double totalDeDesconto;
    private Double totalLiquido;
    private Double fgtsRetido;
    private Double InssRetido;
    private Double inssValorDevido;
    private Double irrf;
    @ManyToOne(cascade = CascadeType.ALL)
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

    public String getDescricaoPag1() {
        return descricaoPag1;
    }

    public int getRefVal1() {
        return refVal1;
    }

    public void setRefVal1(int refVal1) {
        this.refVal1 = refVal1;
    }

    public int getRefDesc1() {
        return refDesc1;
    }

    public void setRefDesc1(int refDesc1) {
        this.refDesc1 = refDesc1;
    }

    public int getRefDesc2() {
        return refDesc2;
    }

    public void setRefDesc2(int refDesc2) {
        this.refDesc2 = refDesc2;
    }

    public int getRefDesc3() {
        return refDesc3;
    }

    public void setRefDesc3(int refDesc3) {
        this.refDesc3 = refDesc3;
    }
    
    

    public int getRefVal2() {
        return refVal2;
    }

    public void setRefVal2(int refVal2) {
        this.refVal2 = refVal2;
    }

    public int getRefVal3() {
        return refVal3;
    }

    public void setRefVal3(int refVal3) {
        this.refVal3 = refVal3;
    }
    
    

    public void setDescricaoPag1(String descricaoPag1) {
        this.descricaoPag1 = descricaoPag1;
    }

    public String getDescricaoPag2() {
        return descricaoPag2;
    }

    public void setDescricaoPag2(String descricaoPag2) {
        this.descricaoPag2 = descricaoPag2;
    }

    public String getDescricaoPag3() {
        return descricaoPag3;
    }

    public void setDescricaoPag3(String descricaoPag3) {
        this.descricaoPag3 = descricaoPag3;
    }

    public double getValorPag1() {
        return valorPag1;
    }

    public void setValorPag1(double valorPag1) {
        this.valorPag1 = valorPag1;
    }

    public double getValorPag2() {
        return valorPag2;
    }

    public void setValorPag2(double valorPag2) {
        this.valorPag2 = valorPag2;
    }

    public double getValorPag3() {
        return valorPag3;
    }

    public void setValorPag3(double valorPag3) {
        this.valorPag3 = valorPag3;
    }

    public String getDescricaoDesc1() {
        return descricaoDesc1;
    }

    public void setDescricaoDesc1(String descricaoDesc1) {
        this.descricaoDesc1 = descricaoDesc1;
    }

    public String getDescricaoDesc2() {
        return descricaoDesc2;
    }

    public void setDescricaoDesc2(String descricaoDesc2) {
        this.descricaoDesc2 = descricaoDesc2;
    }

    public String getDescricaoDesc3() {
        return descricaoDesc3;
    }

    public void setDescricaoDesc3(String descricaoDesc3) {
        this.descricaoDesc3 = descricaoDesc3;
    }

    public double getValorDesc1() {
        return valorDesc1;
    }

    public void setValorDesc1(double valorDesc1) {
        this.valorDesc1 = valorDesc1;
    }

    public double getValorDesc2() {
        return valorDesc2;
    }

    public void setValorDesc2(double valorDesc2) {
        this.valorDesc2 = valorDesc2;
    }

    public double getValorDesc3() {
        return valorDesc3;
    }

    public void setValorDesc3(double valorDesc3) {
        this.valorDesc3 = valorDesc3;
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
