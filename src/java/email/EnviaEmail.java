package email;

import entidade.Empregador;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.*;

public class EnviaEmail {
    
    SimpleEmail email = new SimpleEmail();
 

    public void enviar(Empregador empregador) {

        try {
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setAuthentication("julianozagati2016@gmail.com", "sw8rdoi5");
            email.setSSL(true);
            email.addTo(empregador.getResponsavelEmail());
            email.setFrom("julianozagati2016@gmail.com");
            email.setSubject("GRHWeb - Solicitação de recupeção de senha");
            email.setMsg("Ola Sr(a) "+empregador.getResponsavelNome()+" \n sua senha e: "+empregador.getCnpj().getSenha());
            email.send();

        } catch (EmailException e) {

            System.out.println(e.getMessage());

        }

    }

}
