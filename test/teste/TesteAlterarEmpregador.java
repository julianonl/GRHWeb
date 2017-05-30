package teste;


import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import webService.BuscaCNPJ;

public class TesteAlterarEmpregador {

    public static void main(String[] args) throws IOException, JSONException  {

        BuscaCNPJ buscaCNPJ = new BuscaCNPJ();
        String caminhoUrl = "http://www.receitaws.com.br/v1/cnpj/" + "81034993000114";
        JSONObject obj;
        obj = new JSONObject(buscaCNPJ.pegarHttpGETcnpj(caminhoUrl));
        if (!obj.has("erro")) {
            try {
            System.out.println(obj);

        }catch(Exception e){
            
        }}

   }
    
}
