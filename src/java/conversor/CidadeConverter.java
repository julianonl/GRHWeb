
package conversor;

import dao.DAOCidade;
import entidade.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cidadeConverter")
 public class CidadeConverter implements Converter {
        DAOCidade dao = new DAOCidade();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade c = dao.buscaId(Cidade.class, Long.parseLong(value) );
        return c;
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Cidade c = (Cidade) value;
        return String.valueOf( c.getId() );
    }
}
