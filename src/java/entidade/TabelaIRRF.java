package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class TabelaIRRF implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    private Double valorDeducaoDependente;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeValidadeTabela;

    private Double valorTeto1;
    private Double valorTeto2;
    private Double valorTeto3;
    private Double valorTeto4;
    private Double valorTeto5;

    private Double aliquotaTeto1;
    private Double aliquotaTeto2;
    private Double aliquotaTeto3;
    private Double aliquotaTeto4;
    private Double aliquotaTeto5;

    private Double deducaoTeto1;
    private Double deducaoTeto2;
    private Double deducaoTeto3;
    private Double deducaoTeto4;
    private Double deducaoTeto5;

    public Double getValorDeducaoDependente() {
        return valorDeducaoDependente;
    }

    public void setValorDeducaoDependente(Double valorDeducaoDependente) {
        this.valorDeducaoDependente = valorDeducaoDependente;
    }

    public Date getDataDeValidadeTabela() {
        return dataDeValidadeTabela;
    }

    public void setDataDeValidadeTabela(Date dataDeValidadeTabela) {
        this.dataDeValidadeTabela = dataDeValidadeTabela;
    }

    public Double getValorTeto1() {
        return valorTeto1;
    }

    public void setValorTeto1(Double valorTeto1) {
        this.valorTeto1 = valorTeto1;
    }

    public Double getValorTeto2() {
        return valorTeto2;
    }

    public void setValorTeto2(Double valorTeto2) {
        this.valorTeto2 = valorTeto2;
    }

    public Double getValorTeto3() {
        return valorTeto3;
    }

    public void setValorTeto3(Double valorTeto3) {
        this.valorTeto3 = valorTeto3;
    }

    public Double getValorTeto4() {
        return valorTeto4;
    }

    public void setValorTeto4(Double valorTeto4) {
        this.valorTeto4 = valorTeto4;
    }

    public Double getValorTeto5() {
        return valorTeto5;
    }

    public void setValorTeto5(Double valorTeto5) {
        this.valorTeto5 = valorTeto5;
    }

    public Double getAliquotaTeto1() {
        return aliquotaTeto1;
    }

    public void setAliquotaTeto1(Double aliquotaTeto1) {
        this.aliquotaTeto1 = aliquotaTeto1;
    }

    public Double getAliquotaTeto2() {
        return aliquotaTeto2;
    }

    public void setAliquotaTeto2(Double aliquotaTeto2) {
        this.aliquotaTeto2 = aliquotaTeto2;
    }

    public Double getAliquotaTeto3() {
        return aliquotaTeto3;
    }

    public void setAliquotaTeto3(Double aliquotaTeto3) {
        this.aliquotaTeto3 = aliquotaTeto3;
    }

    public Double getAliquotaTeto4() {
        return aliquotaTeto4;
    }

    public void setAliquotaTeto4(Double aliquotaTeto4) {
        this.aliquotaTeto4 = aliquotaTeto4;
    }

    public Double getAliquotaTeto5() {
        return aliquotaTeto5;
    }

    public void setAliquotaTeto5(Double aliquotaTeto5) {
        this.aliquotaTeto5 = aliquotaTeto5;
    }

    public Double getDeducaoTeto1() {
        return deducaoTeto1;
    }

    public void setDeducaoTeto1(Double deducaoTeto1) {
        this.deducaoTeto1 = deducaoTeto1;
    }

    public Double getDeducaoTeto2() {
        return deducaoTeto2;
    }

    public void setDeducaoTeto2(Double deducaoTeto2) {
        this.deducaoTeto2 = deducaoTeto2;
    }

    public Double getDeducaoTeto3() {
        return deducaoTeto3;
    }

    public void setDeducaoTeto3(Double deducaoTeto3) {
        this.deducaoTeto3 = deducaoTeto3;
    }

    public Double getDeducaoTeto4() {
        return deducaoTeto4;
    }

    public void setDeducaoTeto4(Double deducaoTeto4) {
        this.deducaoTeto4 = deducaoTeto4;
    }

    public Double getDeducaoTeto5() {
        return deducaoTeto5;
    }

    public void setDeducaoTeto5(Double deducaoTeto5) {
        this.deducaoTeto5 = deducaoTeto5;
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
        if (!(object instanceof TabelaIRRF)) {
            return false;
        }
        TabelaIRRF other = (TabelaIRRF) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TabelaIRRF[ id=" + id + " ]";
    }

}
