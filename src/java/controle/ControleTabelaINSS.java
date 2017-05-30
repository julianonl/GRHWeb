package controle;

import dao.DAOGenerico;
import entidade.TabelaINSS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ControleTabelaINSS implements Serializable {

    private DAOGenerico dao = new DAOGenerico();
    private TabelaINSS inss = new TabelaINSS();

    public ControleTabelaINSS() {
        inss=(TabelaINSS) dao.buscarPorId(TabelaINSS.class, 1L);
    }

    public TabelaINSS getInss() {
        return inss;
    }

    public void setInss(TabelaINSS inss) {
        this.inss = inss;
    }

    public List<TabelaINSS> buscaTabelaInss() {
        List<TabelaINSS> listaTabela = new ArrayList<>();
        listaTabela = dao.listar(TabelaINSS.class);

        if (listaTabela.isEmpty()) {
            inss.setId(1L);
            listaTabela.add(inss);
            return listaTabela;

        } else {
            return dao.listar(inss.getClass());
        }

    }

    public void atualizaTabelaInss() {
        if (inss.getId() != null) {
            dao.alterar(inss);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        }
    }

}
