package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Empregador;
import entidade.TabelaHorario;
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
public class ControleHorario {

    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private DAOCnpj daocnpj = new DAOCnpj();
    private DAOGenerico dao = new DAOGenerico();
     private List<TabelaHorario> listaSalario = new ArrayList<TabelaHorario>();

    public ControleHorario() {
    }

    private TabelaHorario horario = new TabelaHorario();

    public TabelaHorario getHorario() {
        return horario;
    }

    public void setHorario(TabelaHorario horario) {
        this.horario = horario;
    }

    public String adicionaHorario() {
        if (horario.getId() == null || horario.getId() == 0) {

            horario.setEmpregador(procuraEmpresa());
            dao.inserir(horario);
            horario = new TabelaHorario();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Horário adicionado com sucesso", ""));

        } else {
            atualizaHorario();
        }

        return null;
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

    private void atualizaHorario() {
        dao.alterar(horario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void limparHorario() {
        horario = new TabelaHorario();
    }
    
       public List<TabelaHorario> buscarHorario() {
       return listaSalario = dao.listarCondic(TabelaHorario.class, "empregador_id", procuraEmpresa().getId());
    }
       
       public void excluirJornada(Long id) {
        dao.remover(horario.getClass(), id);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro"+ id +" eliminado com sucesso", ""));

    }
}
