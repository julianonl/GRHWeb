package validators;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="passwordValidator")
public class PasswordValidator implements Validator {

    int num = 0;
    int carac = 0;

    char[] caracteresEspeciais={'=','|','!','@','#','$','%','^','&','*','(',')','{','}','[',']',';',':','.',',','<','>','?','~','+','-','_','\'','"'};
    
    @Override
    public void validate(FacesContext context,UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }      
        
        String password = (String)value;
     
        for(int i=0;i<password.length();i++) {            
            if(password.charAt(i)>=48 && password.charAt(i)<=57) {
                num++;
            }
        }
        System.out.println("Foram encontrados "+num+" numeros na senha!");                                        
  
        for(int i=0;i<password.length();i++) {
            for(int j=0;j<caracteresEspeciais.length;j++) {
                if(password.charAt(i)==caracteresEspeciais[j]) {
                    carac++;
                }
            }
        }
        System.out.println("Foram encontrados "+carac+" caracteres especias na senha!");

        if(password == null || password.equals("")){
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "A senha não pode ser nula!", ""));             

        } else if(!(carac > 0)|| !(num > 0)){            
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "A senha deve conter números, caracteres especiais e letras!", ""));

        } else if(password.length() < 7){
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "A senha deve ter no mínimo 7 caracteres!", ""));
        } else if(password.length() >= 22){
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "A senha deve ter no máximo 22 caracteres!!!", ""));
        } 
    }
}
