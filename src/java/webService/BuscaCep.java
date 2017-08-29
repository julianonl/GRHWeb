package webService;

import entidade.Cep;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class BuscaCep {

    public final String pegarHttpGETcep(String urlToRead) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException | ProtocolException ex) {
        } catch (IOException ex) {
        }
        return result.toString();
    }

    public final Cep buscar(String cep) throws IOException, JSONException, ParseException {
        Cep cep1 = new Cep();
        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        JSONObject obj = null;
        try {
            obj = new JSONObject(pegarHttpGETcep(url));
        } catch (JSONException ex) {
            Logger.getLogger(BuscaCep.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!obj.has("erro")) {
            try {

                cep1.setCep(obj.getString("cep"));
                cep1.setLogradouro(obj.getString("logradouro"));
                cep1.setComplemento(obj.getString("complemento"));
                cep1.setBairro(obj.getString("bairro"));
                cep1.setIbge(obj.getString("ibge"));

            } catch (JSONException ex) {
                Logger.getLogger(BuscaCep.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
        return cep1;
    }

}
