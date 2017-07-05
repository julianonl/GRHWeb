package controle;

import dao.DAOGenerico;
import entidade.Empregador;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@RequestScoped
public class ControleDadosTemplate {

    private Empregador empregador = new Empregador();
    private DAOGenerico dao = new DAOGenerico();
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();

    public ControleDadosTemplate() {
    }

    public List<Empregador> procuraEmpresa() {

        try {

            if (context instanceof SecurityContext) {
                Authentication authentication = context.getAuthentication();
                if (authentication instanceof Authentication) {

                    login = (((User) authentication.getPrincipal()).getUsername());

                }
            }

            List<Empregador> empregador = dao.listarCondicao(Empregador.class, "cnpj.cnpj", login);
            return empregador;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro na autenticação" + e, ""));
        }
        return null;
    }

    public String buscarLogomarca() {
        List<Empregador> lista = new ArrayList<Empregador>();
        lista = procuraEmpresa();
        String controle;

        for (Empregador empregador1 : lista) {
            empregador.setId(empregador1.getId());

        }
        empregador = (Empregador) dao.buscarPorId(Empregador.class, empregador.getId());

        if (empregador.getLogoMarca() != null) {
            controle = "../recursos/images/" + empregador.getLogoMarca();
        } else {
            controle = "../recursos/images/semLogo.jpg";
        }
        return controle;

    }

}
