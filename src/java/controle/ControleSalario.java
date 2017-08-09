package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Empregador;
import entidade.TabelaSalario;
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

@SessionScoped
@ManagedBean
public class ControleSalario implements Serializable {

    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private DAOCnpj daocnpj = new DAOCnpj();
    private DAOGenerico dao = new DAOGenerico();
    private TabelaSalario salario = new TabelaSalario();
     private List<TabelaSalario> listaSalario = new ArrayList<TabelaSalario>();

    public ControleSalario() {
    }

    public TabelaSalario getSalario() {
        return salario;
    }

    public void setSalario(TabelaSalario salario) {
        this.salario = salario;
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
    
       public List<TabelaSalario> buscarSalario() {
       return listaSalario = dao.listarCondic(TabelaSalario.class, "empregador_id", procuraEmpresa().getId());
    }
       
       public void limparSalario() {
        salario = new TabelaSalario();
    }
       
       
        public String adicionaSalario() {
        if (salario.getId() == null || salario.getId() == 0) {
            salario.setEmpregador(procuraEmpresa());
            dao.inserir(salario);
            salario = new TabelaSalario();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova faixa Salarial adicionada com sucesso", ""));
        } else {
            atualizaSalario();
        }

        return null;
    }

    private void atualizaSalario() {
        dao.alterar(salario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
      public void excluirSalario(Long id) {
        dao.remover(salario.getClass(), id);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro"+ id+" eliminado com sucesso", ""));

    }
      
          public void excluirSalario() {
              
        dao.remover(salario.getClass(), salario.getId());

    }
          
          public String atualizarSalario() {
              
              dao.alterar(salario);
          
          return null;
          }
      

}
