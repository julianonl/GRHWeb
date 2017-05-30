package teste;

import controle.ControleEmpresa;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



public class TesteEmail {

    public static void main(String args[])  {

        /*
        
        SimpleEmail email = new SimpleEmail();


	try {
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("julianozagati2016@gmail.com","sw8rdoi5");			
		email.setSSL(true);
		email.addTo("juliano@copagra.coop.br");
		email.setFrom("julianozagati2016@gmail.com");
		email.setSubject("Teste");
		email.setMsg("teste de envio");
		email.send();

	} catch (EmailException e) {

		System.out.println(e.getMessage());

	}
        
*/
        
        
        ControleEmpresa empresa = new ControleEmpresa();
        
       //empresa.recuperarSenha("11.111.111/1111-11");
        
        
        
    }
}
