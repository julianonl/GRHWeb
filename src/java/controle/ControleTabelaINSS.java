package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import dao.DAOInss;
import entidade.Empregador;
import entidade.TabelaINSS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@SessionScoped
public class ControleTabelaINSS implements Serializable {
    
    private DAOCnpj daocnpj = new DAOCnpj();
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private DAOGenerico dao = new DAOGenerico();
    private TabelaINSS inss = new TabelaINSS();
    private TabelaINSS inss2 = new TabelaINSS();
    private DAOInss daoinss = new DAOInss();
    
    public ControleTabelaINSS() {
        
        if ((daoinss.listarInss(TabelaINSS.class, procuraEmpresa().getId())) != null) {
            inss = (TabelaINSS) daoinss.listarInss(TabelaINSS.class, procuraEmpresa().getId());
        } else {
            inss = (TabelaINSS) dao.buscarPorId(TabelaINSS.class, 1L);
        }
    }
    
    public TabelaINSS getInss2() {
        return inss2;
    }
    
    public void setInss2(TabelaINSS inss2) {
        this.inss2 = inss2;
    }
    
    public TabelaINSS getInss() {
        return inss;
    }
    
    public void setInss(TabelaINSS inss) {
        this.inss = inss;
    }
    
    public List<TabelaINSS> buscaTabelaInss() {
        List<TabelaINSS> listaTabela = new ArrayList<>();
        listaTabela = dao.listar(TabelaINSS.class);
        
        if (listaTabela.isEmpty()) {
            inss.setId(1L);
            listaTabela.add(inss);
            return listaTabela;
            
        } else {
            return dao.listar(inss.getClass());
        }
        
    }
    
    public void atualizaTabelaInss() {
        
        if (inss.getEmpregador() == null&&inss2.getEmpregador()==null ) {
            
            inss2.setAliquotaInss1(inss.getAliquotaInss1());
            inss2.setAliquotaInss2(inss.getAliquotaInss2());
            inss2.setAliquotaInss3(inss.getAliquotaInss3());
            inss2.setBaseInsalubridade(inss.getBaseInsalubridade());
            inss2.setDataDeValidadeTabela(inss.getDataDeValidadeTabela());
            inss2.setFaixa1SalarioFamilia(inss.getFaixa1SalarioFamilia());
            inss2.setFaixa2SalarioFamilia(inss.getFaixa2SalarioFamilia());
            inss2.setInssteto1(inss.getInssteto1());
            inss2.setInssteto2(inss.getInssteto2());
            inss2.setInssteto3(inss.getInssteto3());
            inss2.setSalarioMinimo(inss.getSalarioMinimo());
            inss2.setValor1PagoSalarioFamilia(inss.getValor1PagoSalarioFamilia());
            inss2.setValor2PagoSalarioFamilia(inss.getValor2PagoSalarioFamilia());
            inss2.setEmpregador(procuraEmpresa());
            

            inss = new TabelaINSS();
            
            dao.alterar(inss2);
               
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso (Viculada)", ""));
            
            inss = (TabelaINSS) daoinss.listarInss(TabelaINSS.class, procuraEmpresa().getId());
            
        } else {
            dao.alterar(inss);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        }
        
    }
    
    public Empregador procuraEmpresa() {
        Empregador empregador = new Empregador();
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                login = (((User) authentication.getPrincipal()).getUsername());
            }
        }
        empregador = daocnpj.listarCondicString(login);
        return empregador;
    }
    
}
