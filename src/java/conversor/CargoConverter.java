
package conversor;

import dao.DAOCargo;
import entidade.Cargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cargoConverter")
 public class CargoConverter implements Converter {
        DAOCargo dao = new DAOCargo();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cargo c = dao.buscaId(Long.parseLong(value) );
        return c;
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Cargo c = (Cargo) value;
        return String.valueOf( c.getId() );
    }
}
