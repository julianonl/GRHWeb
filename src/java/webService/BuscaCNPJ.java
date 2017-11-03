
package webService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;


public class BuscaCNPJ {
    public String pegarHttpGETcnpj(String caminhoUrl) throws IOException {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(caminhoUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException | ProtocolException ex) {
        }
        return result.toString();
    }
    
}
