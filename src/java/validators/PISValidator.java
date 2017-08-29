package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "pisValidator")
public class PISValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uIComponent, Object object) throws ValidatorException {

        String plPIS = (String) object;
        int liTamanho = 0;
        StringBuffer lsAux = null;
        StringBuffer lsMultiplicador = new StringBuffer("3298765432");
        int liTotalizador = 0;
        int liResto = 0;
        int liMultiplicando = 0;
        int liMultiplicador = 0;
        boolean lbRetorno = true;
        int liDigito = 99;
        lsAux = new StringBuffer().append(plPIS);
        liTamanho = lsAux.length();
        if (liTamanho != 11) {
            lbRetorno = false;
        }
        if (lbRetorno) {
            for (int i = 0; i < 10; i++) {
                liMultiplicando = Integer.parseInt(lsAux.substring(i, i + 1));
                liMultiplicador = Integer.parseInt(lsMultiplicador.substring(i, i + 1));
                liTotalizador += liMultiplicando * liMultiplicador;
            }
            liResto = 11 - liTotalizador % 11;
            liResto = liResto == 10 || liResto == 11 ? 0 : liResto;
            liDigito = Integer.parseInt("" + lsAux.charAt(10));
            lbRetorno = liResto == liDigito;
        }
        if (!lbRetorno) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Número de PIS inválido!");
            message.setSummary("Número de PIS inválido!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
