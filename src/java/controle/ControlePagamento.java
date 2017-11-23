package controle;

import dao.DAOCnpj;
import dao.DAOGenerico;
import dao.DAOTrabalhador;
import entidade.Empregador;
import entidade.MesReferencia;
import entidade.Pagamento;
import entidade.Rubricas;
import entidade.TabelaINSS;
import entidade.Trabalhador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Juliano
 */
@Named(value = "controlePagamento")
@ViewScoped
public class ControlePagamento implements Serializable {

    private Rubricas rubrica = new Rubricas();
    private Empregador empregador = new Empregador();
    private DAOGenerico dao = new DAOGenerico();
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();
    private DAOCnpj daocnpj = new DAOCnpj();
    private DAOTrabalhador daot = new DAOTrabalhador();
    private MesReferencia mesReferencia = new MesReferencia();
    private MesReferencia m = new MesReferencia();
    private Trabalhador trabalhador = new Trabalhador();
    private List<Trabalhador> listaTabalhador = new ArrayList<Trabalhador>();
    private int refPagamento = 0;
    List<Rubricas> rubricas = new ArrayList<Rubricas>();
    private TabelaINSS tabelaINSS = new TabelaINSS();
    private Pagamento pagamento = new Pagamento();
    private DecimalFormat decimalFormat = new DecimalFormat();

    public ControlePagamento() {
        tabelaINSS = (TabelaINSS) dao.buscarPorId(TabelaINSS.class, procuraEmpresas().getId());
        rubricas = dao.listar(Rubricas.class);

    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getRefPagamento() {
        return refPagamento;
    }

    public void setRefPagamento(int refPagamento) {
        this.refPagamento = refPagamento;
    }

    public MesReferencia getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(MesReferencia mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public List buscaTrabalhador() {

        return listaTabalhador = daot.listarCondicaoLongString(procuraEmpresas().getId(), trabalhador.getNome());
    }

    public List<Trabalhador> getListaTabalhador() {
        return listaTabalhador;
    }

    public void setListaTabalhador(List<Trabalhador> listaTabalhador) {
        this.listaTabalhador = listaTabalhador;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
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

    @PostConstruct
    public void init() {

    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro alterado", "De: " + oldValue + ", Para:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<SelectItem> getTrabalhadorSelectItems() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        List<Trabalhador> trab = dao.listar(Trabalhador.class);
        for (Trabalhador c : trab) {
            item.add(new SelectItem(c, c.getNome()));
        }

        return item;
    }

    public List<SelectItem> selectItems() {
        List<SelectItem> item = new ArrayList<SelectItem>();
        List<Trabalhador> listaTab = daot.listarAtivos(procuraEmpresas().getId());
        for (Trabalhador c : listaTab) {
            item.add(new SelectItem(c, c.getId() + " - " + c.getNome()));
        }
        return item;
    }

    private Integer contador = 0;

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public void adicionaCampo() {
        contador++;
        //Adiciona elemento na lista
    }

    public void removeCampo() {
        contador--;
        //Remove elemento da lista
    }

    public int referencia() {

        m = (MesReferencia) dao.buscarPorId(MesReferencia.class, procuraEmpresas().getId());

        Date dataReferencia = new Date();
        Date dataAdmissao = new Date();
        dataReferencia = m.getDataReferencia();
        dataAdmissao = trabalhador.getDataDeAdmissao();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataReferencia);
        int diaReferencia = cal.get(Calendar.DAY_OF_MONTH);
        int mesReferencia = cal.get(Calendar.MONTH);
        int anoReferencia = cal.get(Calendar.YEAR);

        cal.setTime(dataAdmissao);

        int diaAdmissao = cal.get(Calendar.DAY_OF_MONTH);
        int mesAdmissao = cal.get(Calendar.MONTH);
        int anoAdmissao = cal.get(Calendar.YEAR);

        System.out.println("dia ADM: " + diaAdmissao);
        System.out.println("Mes ADM: " + mesAdmissao);
        System.out.println("Ano ADM: " + anoAdmissao);

        System.out.println("dia ref: " + diaReferencia);
        System.out.println("Mes ref: " + mesReferencia);
        System.out.println("Ano ref: " + anoReferencia);

        if (mesAdmissao == mesReferencia && anoAdmissao == anoReferencia) {

            if (diaAdmissao == 31) {
                refPagamento = 1;

                BigDecimal bd = new BigDecimal((trabalhador.getSalario().getValor() / 30) * refPagamento).setScale(2, RoundingMode.HALF_EVEN);
                pagamento.setSalario(bd.doubleValue());
                calculaINSS();
                return refPagamento;
            } else {
                refPagamento = 30 - (diaAdmissao - 1);
                BigDecimal bd = new BigDecimal((trabalhador.getSalario().getValor() / 30) * refPagamento).setScale(2, RoundingMode.HALF_EVEN);
                pagamento.setSalario(bd.doubleValue());
                calculaINSS();
                return refPagamento;
            }
        } else {
            refPagamento = 30;
            BigDecimal bd = new BigDecimal((trabalhador.getSalario().getValor() / 30) * refPagamento).setScale(2, RoundingMode.HALF_EVEN);
            pagamento.setSalario(bd.doubleValue());
            calculaINSS();
            return refPagamento;
        }

    }

    public Rubricas getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubricas rubrica) {
        this.rubrica = rubrica;
    }

    public List<Rubricas> sugerirRubrica(String consulta) {
        List<Rubricas> rubricasSugeridas = new ArrayList<>();
        for (Rubricas rubrica : this.rubricas) {
            if (rubrica.getNomeRubrica().toLowerCase().startsWith(consulta.toLowerCase())) {
                rubricasSugeridas.add(rubrica);
            }
        }
        return rubricasSugeridas;
    }

    public void calculaINSS() {
        pagamento.setTotalDeProventos(pagamento.getSalario());

        if (pagamento.getTotalDeProventos() <= tabelaINSS.getInssteto1()) {
            BigDecimal bd = new BigDecimal(pagamento.getTotalDeProventos() * 0.08).setScale(2, RoundingMode.HALF_EVEN);
            pagamento.setInssRetido(bd.doubleValue());

        } else if (pagamento.getTotalDeProventos() > tabelaINSS.getInssteto1() && pagamento.getTotalDeProventos() <= tabelaINSS.getInssteto2()) {
            BigDecimal bd = new BigDecimal(pagamento.getTotalDeProventos() * 0.09).setScale(2, RoundingMode.HALF_EVEN);
            pagamento.setInssRetido(bd.doubleValue());

        } else if (pagamento.getTotalDeProventos() > tabelaINSS.getInssteto2() && pagamento.getTotalDeProventos() <= tabelaINSS.getInssteto3()) {
            BigDecimal bd = new BigDecimal(pagamento.getTotalDeProventos() * 0.11).setScale(2, RoundingMode.HALF_EVEN);
            pagamento.setInssRetido(bd.doubleValue());

        }
        
        else if (pagamento.getTotalDeProventos() > tabelaINSS.getInssteto3()){
            BigDecimal bd = new BigDecimal(tabelaINSS.getInssteto3() * 0.11).setScale(2, RoundingMode.HALF_EVEN);
            pagamento.setInssRetido(bd.doubleValue());

        }
        
   
        
        

    }
    
    
         public void fgtsRetido(){
        
        
        
        }

}
