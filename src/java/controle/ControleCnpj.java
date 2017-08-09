package controle;

import dao.DAOCidade;
import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Cidade;
import entidade.Empregador;
import imagensUpload.ImagenUpload;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@SessionScoped
public class ControleCnpj implements Serializable{

    private DAOGenerico dao = new DAOGenerico();
    private DAOCnpj daocnpj = new DAOCnpj();
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private Empregador empregador = new Empregador();
    List<Cidade> cidades = new ArrayList<Cidade>();
    DAOCidade daoCid = new DAOCidade();

    public ControleCnpj() {
        empregador = procuraEmpresa();
        cidades = daoCid.listaCidade();
    }

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
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

    public void atualizaEmpresa() {
        if (empregador.getId() != null) {
            dao.alterar(empregador);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        }
    }
    
        public List<Cidade> sugerirCidade(String consulta) {
        List<Cidade> cidadesSugeridas = new ArrayList<>();
        for (Cidade cidade : this.cidades) {
            if (cidade.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
                cidadesSugeridas.add(cidade);
            }
        }
        return cidadesSugeridas;
    }
        
        
        public String buscarLogomarca() {
        
        String controle;
        if (empregador.getLogoMarca() != null) {
            controle = "../recursos/images/logo/" + empregador.getLogoMarca();
        } else {
            controle = "../recursos/images/logo/semLogo.jpg";
        }
        return controle;

    }
        
        public void salvarLogonarca(FileUploadEvent event) {
            ImagenUpload imagen = new ImagenUpload();           
            empregador.setLogoMarca(imagen.salvarLogonarca(event, "logo"));
                    
    }
        

}
