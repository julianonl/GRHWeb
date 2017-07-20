package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Empregador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
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

            List<Empregador> listaEmpregador = dao.listarCondicao(Empregador.class, "cnpj.cnpj", login);

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
            controle = "../recursos/images/" + empregador.getLogoMarca();
        } else {
            controle = "../recursos/images/semLogo.jpg";
        }
        return controle;

    }

    public void enviaLogonarca(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        FacesContext aFacesContext = FacesContext.getCurrentInstance();
        ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
        String realPath = context.getRealPath("/");
        String controleNome = file.getFileName();
        String caminho = realPath + "recursos" + File.separator + "images" + File.separator + controleNome;
        String caminhoAlterado = caminho.replace("\\build", "");

        try {
            FileInputStream in = (FileInputStream) file.getInputstream();
            FileOutputStream out = new FileOutputStream(caminhoAlterado);

            byte[] buffer = new byte[(int) file.getSize()];
            int contador = 0;

            while ((contador = in.read(buffer)) != -1) {
                out.write(buffer, 0, contador);
            }
            in.close();
            out.close();

            List<Empregador> lista = new ArrayList<Empregador>();
            lista = procuraEmpresa();
            String controle;

            for (Empregador empregador1 : lista) {
                empregador.setId(empregador1.getId());

            }
            empregador = (Empregador) dao.buscarPorId(Empregador.class, empregador.getId());

            empregador.setLogoMarca(controleNome);

            dao.alterar(empregador);

            FacesMessage msg = new FacesMessage("A Logomarca ", file.getFileName() + " foi alterada com sucesso.");
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

}
