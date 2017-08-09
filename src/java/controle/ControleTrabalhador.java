package controle;

import dao.DAOCidade;
import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Cidade;
import entidade.Empregador;
import imagensUpload.ImagenUpload;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@SessionScoped
public class ControleTrabalhador implements Serializable {

    private DAOGenerico dao = new DAOGenerico();
    private DAOCnpj daocnpj = new DAOCnpj();
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private Empregador empregador = new Empregador();
    List<Cidade> cidades = new ArrayList<Cidade>();
    DAOCidade daoCid = new DAOCidade();
    

    public ControleTrabalhador() {
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

    public List<Cidade> sugerirCidade(String consulta) {
        List<Cidade> cidadesSugeridas = new ArrayList<>();
        for (Cidade cidade : this.cidades) {
            if (cidade.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
                cidadesSugeridas.add(cidade);
            }
        }
        return cidadesSugeridas;
    }

    public void salvarFoto(FileUploadEvent event) {
        ImagenUpload imagen = new ImagenUpload();

    }
    
    
       public void cadastrarFuncionario() {
        Date date = new Date();
        if (empregador.getId() == null || empregador.getId() == 0) {
            empregador.setDataDeCadastro(date);
           
        } else {
            //updatePessoa();
        }

     
    }

}
