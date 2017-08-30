package controle;

import dao.DAOCargo;
import dao.DAOCidade;
import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Cargo;
import entidade.Cep;
import entidade.Cidade;
import entidade.DescricaoCargo;
import entidade.Empregador;
import entidade.Instrucao;
import entidade.Nacionalidade;
import entidade.TabelaSalario;
import entidade.Trabalhador;
import imagensUpload.ImagenUpload;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.json.JSONException;
import org.primefaces.event.FileUploadEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import webService.BuscaCep;

@ManagedBean
@SessionScoped
public class ControleTrabalhador implements Serializable {

    private String cep;
    private String foto;
    private DAOGenerico dao = new DAOGenerico();
    private Trabalhador trabalhador = new Trabalhador();
    private DAOCnpj daocnpj = new DAOCnpj();
    private String login;
    private Cargo cargo;
    SecurityContext context = SecurityContextHolder.getContext();
    private Empregador empregador = new Empregador();
    List<Cidade> cidades = new ArrayList<Cidade>();
    List<Cargo> cargos = new ArrayList<Cargo>();
    DAOCidade daoCid = new DAOCidade();
    private Cep cep1 = new Cep();
    BuscaCep buscaCep = new BuscaCep();
    private ImagenUpload imagen = new ImagenUpload();
    private TabelaSalario salario1 = new TabelaSalario();
    List<TabelaSalario> salario = new ArrayList<TabelaSalario>();

    private Cargo cargos1 = new Cargo();

    private DescricaoCargo descricaoCargo = new DescricaoCargo();

    public ControleTrabalhador() {
        DAOCidade daoCid = new DAOCidade();
        DAOCargo daoCargo = new DAOCargo();
        cidades = daoCid.listaCidade();
        cargos = daoCargo.listar();
    }

    public void atualizaCargos() {
        DAOCargo daoCargo = new DAOCargo();
        cargos = daoCargo.listar();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cep getCep1() {
        return cep1;
    }

    public void setCep1(Cep cep1) {
        this.cep1 = cep1;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public void limpaFuncionario() {
        trabalhador = new Trabalhador();
        cep1 = new Cep();
    }

    public void cadastrarFuncionario() {
        Date date = new Date();
        if (trabalhador.getId() == null || trabalhador.getId() == 0) {
            trabalhador.setDataDeCadastro(date);
            trabalhador.setEmpregador(procuraEmpresa());
            trabalhador.setEstatus("Ativo");
            trabalhador.setFoto(foto);
            trabalhador.setCargo(cargo);
            trabalhador.setCep(cep1);
            dao.inserir(trabalhador);
            limpaFuncionario();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));

        } else {
            updateTrabalhador();
        }
    }

    private void updateTrabalhador() {
        dao.alterar(trabalhador);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void buscarCep() throws IOException, JSONException, ParseException {
        cep1 = buscaCep.buscar(cep);
    }

    public String buscarFotos() {

        String controle;
        if (foto != null) {
            controle = "../recursos/images/fotos/" + foto;
        } else {
            controle = "../recursos/images/fotos/semFoto.jpg";
        }
        return controle;

    }

    public void salvarFotos(FileUploadEvent event) {

        foto = imagen.salvarLogonarca(event, "fotos");

    }

    public ArrayList<SelectItem> getComboUF() {
        ArrayList lista = new ArrayList();
        lista.add(new SelectItem("-"));
        lista.add(new SelectItem("AC"));
        lista.add(new SelectItem("AL"));
        lista.add(new SelectItem("AM"));
        lista.add(new SelectItem("AP"));
        lista.add(new SelectItem("BA"));
        lista.add(new SelectItem("CE"));
        lista.add(new SelectItem("DF"));
        lista.add(new SelectItem("ES"));
        lista.add(new SelectItem("GO"));
        lista.add(new SelectItem("MA"));
        lista.add(new SelectItem("MG"));
        lista.add(new SelectItem("MS"));
        lista.add(new SelectItem("MT"));
        lista.add(new SelectItem("PA"));
        lista.add(new SelectItem("PB"));
        lista.add(new SelectItem("PE"));
        lista.add(new SelectItem("PI"));
        lista.add(new SelectItem("PR"));
        lista.add(new SelectItem("RJ"));
        lista.add(new SelectItem("RN"));
        lista.add(new SelectItem("RO"));
        lista.add(new SelectItem("RR"));
        lista.add(new SelectItem("RS"));
        lista.add(new SelectItem("SC"));
        lista.add(new SelectItem("SE"));
        lista.add(new SelectItem("SP"));
        lista.add(new SelectItem("TO"));

        return lista;
    }

    public ArrayList<SelectItem> getComboSexo() {
        ArrayList lista = new ArrayList();
        lista.add(new SelectItem("-"));
        lista.add(new SelectItem("MASCULINO"));
        lista.add(new SelectItem("FEMININO"));

        return lista;
    }

    public ArrayList<SelectItem> getComboEstadoCivil() {
        ArrayList lista = new ArrayList();
        lista.add(new SelectItem("-"));
        lista.add(new SelectItem("SOLTEIRO"));
        lista.add(new SelectItem("CASADO"));
        lista.add(new SelectItem("VIUVO"));
        lista.add(new SelectItem("DIVORCIADO"));
        lista.add(new SelectItem("SEPARADO JUD."));
        lista.add(new SelectItem("MARITAL"));
        lista.add(new SelectItem("OUTROS"));

        return lista;
    }

    public ArrayList<SelectItem> getComboBanco() {
        ArrayList lista = new ArrayList();
        lista.add(new SelectItem("-"));
        lista.add(new SelectItem("001 - BANCO DO BRASIL"));
        lista.add(new SelectItem("033 - BANESPA, BANCO DO ESTADO DE SÃO PAULO"));
        lista.add(new SelectItem("041 - BANRISUL, BANCO DO ESTADO DO RIO GRANDE DO SUL"));
        lista.add(new SelectItem("047 - BANESE, BANCO DO ESTADO DE SERGIPE"));
        lista.add(new SelectItem("237 - BRADESCO, BANCO BRASILEIRO DE DESCONTOS"));
        lista.add(new SelectItem("104 - CAIXA ECONÔMICA FEDERAL"));
        lista.add(new SelectItem("745 - CITIBANK"));
        lista.add(new SelectItem("399 - H.S.B.C"));
        lista.add(new SelectItem("341 - BANCO ITAU"));
        lista.add(new SelectItem("623 - BANCO PANAMERICANO"));
        lista.add(new SelectItem("356 - BANCO REAL-ABN"));
        lista.add(new SelectItem("422 - BANCO SAFRA"));
        lista.add(new SelectItem("353 - SANTANDER"));
        lista.add(new SelectItem("748 - SICREDI"));
        lista.add(new SelectItem("069 - BPN BRASIL, BANCO MULTIPLO SA"));
        lista.add(new SelectItem("021 - BANESTES, BANCO DO ESTADO DO ESPÍRITO SANTO"));
        lista.add(new SelectItem("070 - BANCO DE BRASILIA"));
        lista.add(new SelectItem("756 - SICOOB"));
        lista.add(new SelectItem("999 - PAGAMENTO ATRAVÉS DE CHEQUE"));

        return lista;
    }

    public List<SelectItem> getInstrucao() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        List<Instrucao> instrucao = dao.listar(Instrucao.class);
        for (Instrucao c : instrucao) {
            item.add(new SelectItem(c, c.getId() + " - " + c.getDescricaoInstrucao()));
        }
        return item;
    }

    public List<SelectItem> getSalario() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        salario = dao.listar(TabelaSalario.class);
        for (TabelaSalario c : salario) {
            item.add(new SelectItem(c, "R$ - " + c.getValor()));
        }
        return item;
    }

    public List<SelectItem> getNacionalidade() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        List<Nacionalidade> nacionalidade = dao.listar(Nacionalidade.class);
        for (Nacionalidade c : nacionalidade) {
            item.add(new SelectItem(c, c.getPaisNacionalidade()));
        }
        return item;
    }

    public List<Cargo> sugerirCargo(String consulta) {
        List<Cargo> cargosSugeridos = new ArrayList<>();
        for (Cargo cargo : this.cargos) {
            if (cargo.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
                cargosSugeridos.add(cargo);
            }
        }
        return cargosSugeridos;
    }

    public String adicionaCargo() {
        if (cargos1.getId() == null || cargos1.getId() == 0) {
            cargos1.setDescricaoCargo(descricaoCargo);
            cargos1.setEmpregador(procuraEmpresa());
            dao.inserir(cargos1);
            atualizaCargos();

            cargos1 = new Cargo();
            descricaoCargo = new DescricaoCargo();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo adicionado com sucesso", ""));

        } else {
            atualizaCargo();
        }

        return null;
    }

    private void atualizaCargo() {
        dao.alterar(cargos);
        atualizaCargos();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void limparCargo() {
        cargos1 = new Cargo();
        descricaoCargo = new DescricaoCargo();
    }

    public Cargo getCargos1() {
        return cargos1;
    }

    public void setCargos1(Cargo cargos1) {
        this.cargos1 = cargos1;
    }

    public DescricaoCargo getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(DescricaoCargo descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public String adicionaSalario() {
        if (salario1.getId() == null || salario1.getId() == 0) {
            salario1.setEmpregador(procuraEmpresa());
            dao.inserir(salario1);
            salario1 = new TabelaSalario();
            atualizaListaSalario();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova faixa Salarial adicionada com sucesso", ""));
        } else {
            atualizaSalario();
        }

        return null;
    }

    private void atualizaSalario() {
        dao.alterar(salario1);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public TabelaSalario getSalario1() {
        return salario1;
    }

    public void setSalario1(TabelaSalario salario1) {
        this.salario1 = salario1;
    }

    public void atualizaListaSalario() {
        salario = dao.listar(TabelaSalario.class);
    }

    public List<Trabalhador> procuraTrabalhador() {
        
        List<Trabalhador> trabalhador = new ArrayList<Trabalhador>();
        trabalhador=dao.listarCondic2(Trabalhador.class,"empregador",procuraEmpresa().getId());
        
        return trabalhador;
    }

}
