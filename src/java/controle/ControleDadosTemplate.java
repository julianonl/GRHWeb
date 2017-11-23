package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import dao.DaoMesReferencia;
import entidade.Empregador;
import entidade.MesReferencia;
import imagensUpload.ImagenUpload;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
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
    private DAOCnpj daocnpj = new DAOCnpj();
    private DaoMesReferencia daoMes = new DaoMesReferencia();
    private MesReferencia mesReferencia = new MesReferencia();
    
    
    private String data;
    public ControleDadosTemplate() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
    

    public MesReferencia getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(MesReferencia mesReferencia) {
        this.mesReferencia = mesReferencia;
    }
    
    

    public List<Empregador> procuraEmpresa() {

        try {
            if (context instanceof SecurityContext) {
                Authentication authentication = context.getAuthentication();
                if (authentication instanceof Authentication) {
                    login = (((User) authentication.getPrincipal()).getUsername());
                }
            }
            List<Empregador> listaEmpregador = dao.listarCondicao(Empregador.class, "cnpj.cnpj", login);
            buscaMes();
            return listaEmpregador;
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
            controle = "../recursos/images/logo/" + empregador.getLogoMarca();
        } else {
            controle = "../recursos/images/logo/semLogo.jpg";
        }
        return controle;

    }

    public Empregador procuraEmpresas() {
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

    public void enviaLogonarca(FileUploadEvent event) {

        ImagenUpload imagen = new ImagenUpload();
        empregador = procuraEmpresas();
        empregador.setLogoMarca(imagen.salvarLogonarca(event, "logo"));
        dao.alterar(empregador);
        FacesMessage msg = new FacesMessage("A Logomarca foi alterada com sucesso.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);

    }
    
    public void buscaMes(){
    empregador = procuraEmpresas();
    mesReferencia=daoMes.listarMesCondic(mesReferencia.getClass(), empregador.getId());
    
    data=new SimpleDateFormat("MMMM / yyyy").format(mesReferencia.getDataReferencia());
    
    }

}
