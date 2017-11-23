
package conversor;

import dao.DAOGenerico;
import entidade.Rubricas;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("rubricaConverter")
 public class RubricaConverter implements Converter {
        DAOGenerico dao = new DAOGenerico();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Rubricas c = (Rubricas) dao.buscarPorId(Rubricas.class, Long.parseLong(value) );
        return c;
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Rubricas c = (Rubricas) value;
        return String.valueOf( c.getId() );
    }
}
