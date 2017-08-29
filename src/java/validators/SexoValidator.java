package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="sexoValidator")
public class SexoValidator implements Validator{

        @Override
	public void validate(FacesContext facesContext, 
        UIComponent uIComponent, Object object) throws ValidatorException {
        
        String uf = (String)object;

      
        if (uf.equals("-")) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Selecione o Sexo!");
            message.setSummary("Selecione o Sexo!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}