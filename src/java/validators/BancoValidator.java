package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="bancoValidator")
public class BancoValidator implements Validator{

        @Override
	public void validate(FacesContext facesContext, 
        UIComponent uIComponent, Object object) throws ValidatorException {
        
        String banco = (String)object;

      
        if (banco.equals("-")) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Selecione o Banco!");
            message.setSummary("Selecione o Banco!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}