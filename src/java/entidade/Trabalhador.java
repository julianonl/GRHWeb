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
public class Trabalhador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

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
    
    
    
    
    
    
    
    
    
    




}
