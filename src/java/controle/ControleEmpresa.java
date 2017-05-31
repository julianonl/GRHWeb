package controle;

import dao.DAOCidade;
import dao.DAOCnpj;
import dao.DAOGenerico;
import email.EnviaEmail;
import entidade.Cep;
import entidade.Cidade;
import entidade.Cnpj;
import entidade.Empregador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import webService.BuscaCNPJ;
import webService.BuscaCep;

@ManagedBean
@RequestScoped
public class ControleEmpresa implements Serializable {

    private Cep cepCnpj = new Cep();
    private Cep cepResponsavel = new Cep();
    private String cep;
    private String cnpj;
    private Cnpj entidadeCnpj = new Cnpj();
    private BuscaCep buscaCep = new BuscaCep();
    private BuscaCNPJ buscaCNPJ = new BuscaCNPJ();
    private Empregador empregador = new Empregador();
    private Cidade cidade = new Cidade();
    private DAOCnpj daoCnpj = new DAOCnpj();
    private DAOGenerico dao = new DAOGenerico();
    private DAOCidade daoCidade = new DAOCidade();
    private String confereSenha;
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    List<Cidade> cidades = new ArrayList<Cidade>();
    List<Cep> listaCep = new ArrayList<Cep>();

    public ControleEmpresa() {
        DAOCidade daoCid = new DAOCidade();
        cidades = daoCid.listaCidade();
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

    public String getCnpj() {
        return cnpj;
    }

    public Cnpj getEntidadeCnpj() {
        return entidadeCnpj;
    }

    public void setEntidadeCnpj(Cnpj entidadeCnpj) {
        this.entidadeCnpj = entidadeCnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cep getCepCnpj() {
        return cepCnpj;
    }

    public void setCepCnpj(Cep cepCnpj) {
        this.cepCnpj = cepCnpj;
    }

    public Cep getCepResponsavel() {
        return cepResponsavel;
    }

    public void setCepResponsavel(Cep cepResponsavel) {
        this.cepResponsavel = cepResponsavel;
    }

    public final void buscar() throws IOException, JSONException, ParseException {

        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        JSONObject obj = null;
        try {
            obj = new JSONObject(buscaCep.pegarHttpGETcep(url));
        } catch (JSONException ex) {
            Logger.getLogger(ControleEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!obj.has("erro")) {

            try {
                cepResponsavel.setCep(obj.getString("cep"));
                cepResponsavel.setLogradouro(obj.getString("logradouro"));
                cepResponsavel.setComplemento(obj.getString("complemento"));
                cepResponsavel.setBairro(obj.getString("bairro"));
                cepResponsavel.setIbge(obj.getString("ibge"));

            } catch (JSONException ex) {
                Logger.getLogger(ControleEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }
    }

    public List<SelectItem> getCidade() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        DAOCidade daoCid = new DAOCidade();
        for (Cidade c : daoCid.listaCidade()) {
            item.add(new SelectItem(c, c.getNome()));
        }
        return item;
    }

    public List<Empregador> getLista() {

        return listaEmpregador();
    }

    public void salvar() {
        dao.inserir(empregador);
    }

    public String acaoAlterar(Empregador empregador) {
        this.empregador = empregador;

        return "";
    }

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
    }

    public void excluirEmpregador(long id) {
        dao.remover(empregador.getClass(), id);

    }

    public List<Empregador> listaEmpregador() {
        List<Empregador> empregador = dao.listar(Empregador.class);
        return empregador;
    }

    private void insertPessoa() {
        if (entidadeCnpj.getSenha() == null ? confereSenha == null : entidadeCnpj.getSenha().equals(confereSenha)) {
            entidadeCnpj.setPermissao("ROLE_ADMIN");
            empregador.setCep(cepResponsavel);
            empregador.setCnpj(entidadeCnpj);
            dao.inserir(empregador);
            
//             EnviaEmail cadastro = new EnviaEmail();
// 
//            
//            cadastro.enviarEmail(
//                    empregador.getResponsavelEmail(),
//                    "GRHWeb - Bem vindo",
//                    "Olá Sr(a) "+empregador.getResponsavelNome()+" seu cadastro no sistema GRHWeb foi concluido com sucesso.\n Usuário: "+ 
//                            empregador.getCnpj().getCnpj()+"\nSenha: "+empregador.getCnpj().getSenha()+
//                            "\n\n\n\n Atenciosamente\n\nEquipe GRHWeb" );

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
            limpPessoa();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "As senhas não conferem.", ""));
        }
    }

    public void limpPessoa() {
        empregador = new Empregador();
        cepCnpj = new Cep();
        cepResponsavel = new Cep();
        entidadeCnpj = new Cnpj();
    }

    public String editPessoa() {
        this.empregador = empregador;
        return "";
    }

    public String addPessoa() {

        Date date = new Date();
        if (empregador.getId() == null || empregador.getId() == 0) {
            empregador.setDataDeCadastro(date);
            entidadeCnpj.setCep(cepCnpj);
            dao.inserir(entidadeCnpj);
            insertPessoa();
        } else {
            updatePessoa();
        }

        return null;
    }

    private void updatePessoa() {
        dao.alterar(empregador);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
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

            empregador.setLogoMarca(controleNome);
            dao.alterar(empregador);

            FacesMessage msg = new FacesMessage("A Logomarca ", file.getFileName() + " foi alterada com sucesso.");
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
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

    public void buscaCnpj() throws IOException, JSONException, ParseException {

        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");
        String caminhoUrl = "http://www.receitaws.com.br/v1/cnpj/" + cnpj;
        JSONObject obj;
        obj = new JSONObject(buscaCNPJ.pegarHttpGETcnpj(caminhoUrl));
        if (!obj.has("erro")) {
            try {
                entidadeCnpj.setCnpj(obj.getString("cnpj"));
                entidadeCnpj.setTipo(obj.getString("tipo"));
                entidadeCnpj.setRazaoSocial(obj.getString("nome"));
                entidadeCnpj.setNomeFantasia(obj.getString("fantasia"));
                JSONArray jArray = obj.getJSONArray("atividade_principal");
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject e = jArray.getJSONObject(i);
                    entidadeCnpj.setNumeroCnae(e.getString("code"));
                    entidadeCnpj.setDescricaoCnae(e.getString("text"));
                }

                entidadeCnpj.setNaturezaJuridica(obj.getString("natureza_juridica"));
                cepCnpj.setCep(obj.getString("cep"));
                cepCnpj.setLogradouro(obj.getString("logradouro"));
                cepCnpj.setNumeroEndereco(obj.getString("numero"));
                cepCnpj.setComplemento(obj.getString("complemento"));
                cepCnpj.setBairro(obj.getString("bairro"));
                empregador.setResponsavelEmail(obj.getString("email"));
                entidadeCnpj.setTelefone(obj.getString("telefone"));
                entidadeCnpj.setSituacaoAtivaInativa(obj.getString("situacao"));

                String dataAbertura = obj.getString("abertura");
                String dataSituacao = obj.getString("data_situacao");
                String pattern = "dd/MM/yyyy";
                DateFormat df = new SimpleDateFormat(pattern);
                Date dataAbert = df.parse(dataAbertura);
                Date dataDituac = df.parse(dataAbertura);
                entidadeCnpj.setAbertura(dataAbert);
                entidadeCnpj.setDataSituacao(dataDituac);

            } catch (JSONException ex) {
                Logger.getLogger(ControleEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                FacesMessage msg = new FacesMessage("CNPJ não encontrado");
                FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
            }
        }
    }

    public void salvarLogonarca(FileUploadEvent event) {
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

            empregador.setLogoMarca(controleNome);
            System.out.println(controleNome);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void recuperarSenha() {
        EnviaEmail recuperar = new EnviaEmail();
 

        if (entidadeCnpj.getCnpj() != null) {
            empregador = daoCnpj.listarCondicString(entidadeCnpj.getCnpj());
            System.out.println(empregador.getResponsavelEmail());
            
            recuperar.enviarEmail(
                    
                    empregador.getResponsavelEmail(),
                    "GRHWeb - Solicitação de recupeção de senha",
                    "Olá Sr(a) "+empregador.getResponsavelNome()+" sua senha é: "+ empregador.getCnpj().getSenha()+
                            "\n\n\n\n Atenciosamente\n\nEquipe GRHWeb"
                    );
           
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado para " + empregador.getResponsavelEmail(), ""));

        } else {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe o numero do CNPJ", ""));

        }
    }
    
  
}
