package controle;

import dao.DAOGenerico;
import entidade.TabelaIRRF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@SessionScoped
@ManagedBean
public class ControleTabelaIRRF implements Serializable {

    private TabelaIRRF irrf = new TabelaIRRF();
    private DAOGenerico dao = new DAOGenerico();

    public ControleTabelaIRRF() {
         irrf=(TabelaIRRF) dao.buscarPorId(TabelaIRRF.class, 1L);
    }

    public TabelaIRRF getIrrf() {
        return irrf;
    }

    public void setIrrf(TabelaIRRF irrf) {
        this.irrf = irrf;
    }
    
    
    
    public List<TabelaIRRF> buscaTabelaIrrf() {
        List<TabelaIRRF> listaTabela = new ArrayList<>();
        listaTabela = dao.listar(TabelaIRRF.class);

        if (listaTabela.isEmpty()) {
            irrf.setId(1L);
            listaTabela.add(irrf);
            return listaTabela;

        } else {
            return dao.listar(irrf.getClass());
        }

    }

    public void atualizaTabelaIrrf() {
        if (irrf.getId() != null) {
            dao.alterar(irrf);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        }
    }

}
