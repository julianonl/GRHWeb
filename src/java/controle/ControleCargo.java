package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Cargo;
import entidade.DescricaoCargo;
import entidade.Empregador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
public class ControleCargo implements Serializable {

    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private Cargo cargos = new Cargo();
    private Cargo cargo;
    private DescricaoCargo descricaoCargo = new DescricaoCargo();
    private DAOGenerico dao = new DAOGenerico();
    private DAOCnpj daocnpj = new DAOCnpj();

    public ControleCargo() {

    }

    public DescricaoCargo getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(DescricaoCargo descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public Cargo getCargos() {
        return cargos;
    }

    public void setCargos(Cargo cargos) {
        this.cargos = cargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
        descricaoCargo.setDescricao(cargo.getDescricaoCargo().getDescricao());
    }

    public boolean filtrarNome(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        if (value == null) {
            return false;
        }
        String carName = value.toString().toUpperCase();
        filterText = filterText.toUpperCase();
        if (carName.contains(filterText)) {
            return true;
        } else {
            return false;
        }
    }

    public String getNameLowerCase() {
        if (cargo.getNome() == null) {
            return null;
        }
        return cargo.getNome().toLowerCase();
    }

    private List<Cargo> listaCargo = new ArrayList<Cargo>();

    public List<Cargo> buscar() {

        return listaCargo = dao.listar(Cargo.class);
    }

    public List<Cargo> buscarCargo() {

        return listaCargo = dao.listarCondic(Cargo.class, "empregador_id", procuraEmpresa().getId());
    }

    public void editaCargo(Cargo cargos) {
        this.cargos = cargos;
        System.out.println(cargos.getNome());

    }

    public void excluirCargo() {
        dao.remover(cargo.getClass(), cargo.getId());

    }

    public String atualizarCargo() {

        cargo.setDescricaoCargo(descricaoCargo);
        cargo.setEmpregador(procuraEmpresa());
        dao.alterar(cargo);
        cargo = new Cargo();
        descricaoCargo = new DescricaoCargo();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo adicionado com sucesso", ""));

        return null;
    }

    public String adicionaCargo() {
        if (cargos.getId() == null || cargos.getId() == 0) {
            cargos.setDescricaoCargo(descricaoCargo);
            cargos.setEmpregador(procuraEmpresa());
            dao.inserir(cargos);
            cargos = new Cargo();
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
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void limparCargo() {
        cargos = new Cargo();
        descricaoCargo = new DescricaoCargo();
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
