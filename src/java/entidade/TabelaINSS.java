package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class TabelaINSS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double baseInsalubridade;
    private Double salarioMinimo;
    private Double faixa1SalarioFamilia;
    private Double valor1PagoSalarioFamilia;
    private Double faixa2SalarioFamilia;
    private Double valor2PagoSalarioFamilia;
    private Double inssteto1;
    private Double aliquotaInss1;
    private Double inssteto2;
    private Double aliquotaInss2;
    private Double inssteto3;
    private Double aliquotaInss3;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeValidadeTabela;

    public Double getBaseInsalubridade() {
        return baseInsalubridade;
    }

    public void setBaseInsalubridade(Double baseInsalubridade) {
        this.baseInsalubridade = baseInsalubridade;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Double getFaixa1SalarioFamilia() {
        return faixa1SalarioFamilia;
    }

    public void setFaixa1SalarioFamilia(Double faixa1SalarioFamilia) {
        this.faixa1SalarioFamilia = faixa1SalarioFamilia;
    }

    public Double getValor1PagoSalarioFamilia() {
        return valor1PagoSalarioFamilia;
    }

    public void setValor1PagoSalarioFamilia(Double valor1PagoSalarioFamilia) {
        this.valor1PagoSalarioFamilia = valor1PagoSalarioFamilia;
    }

    public Double getFaixa2SalarioFamilia() {
        return faixa2SalarioFamilia;
    }

    public void setFaixa2SalarioFamilia(Double faixa2SalarioFamilia) {
        this.faixa2SalarioFamilia = faixa2SalarioFamilia;
    }

    public Double getValor2PagoSalarioFamilia() {
        return valor2PagoSalarioFamilia;
    }

    public void setValor2PagoSalarioFamilia(Double valor2PagoSalarioFamilia) {
        this.valor2PagoSalarioFamilia = valor2PagoSalarioFamilia;
    }

    public Double getInssteto1() {
        return inssteto1;
    }

    public void setInssteto1(Double inssteto1) {
        this.inssteto1 = inssteto1;
    }

    public Double getAliquotaInss1() {
        return aliquotaInss1;
    }

    public void setAliquotaInss1(Double aliquotaInss1) {
        this.aliquotaInss1 = aliquotaInss1;
    }

    public Double getInssteto2() {
        return inssteto2;
    }

    public void setInssteto2(Double inssteto2) {
        this.inssteto2 = inssteto2;
    }

    public Double getAliquotaInss2() {
        return aliquotaInss2;
    }

    public void setAliquotaInss2(Double aliquotaInss2) {
        this.aliquotaInss2 = aliquotaInss2;
    }

    public Double getInssteto3() {
        return inssteto3;
    }

    public void setInssteto3(Double inssteto3) {
        this.inssteto3 = inssteto3;
    }

    public Double getAliquotaInss3() {
        return aliquotaInss3;
    }

    public void setAliquotaInss3(Double aliquotaInss3) {
        this.aliquotaInss3 = aliquotaInss3;
    }

   

    public Date getDataDeValidadeTabela() {
        return dataDeValidadeTabela;
    }

    public void setDataDeValidadeTabela(Date dataDeValidadeTabela) {
        this.dataDeValidadeTabela = dataDeValidadeTabela;
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
        if (!(object instanceof TabelaINSS)) {
            return false;
        }
        TabelaINSS other = (TabelaINSS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TabelaINSS[ id=" + id + " ]";
    }

}
