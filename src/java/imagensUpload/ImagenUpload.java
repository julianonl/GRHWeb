
package imagensUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


public class ImagenUpload {
    
      
        public String salvarLogonarca(FileUploadEvent event, String pasta) {
        UploadedFile file = event.getFile();
        FacesContext aFacesContext = FacesContext.getCurrentInstance();
        ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
        String realPath = context.getRealPath("/");
        String controleNome = file.getFileName();
        String caminho = realPath + "recursos" + File.separator + "images" + File.separator + pasta + File.separator + controleNome;
        String caminhoAlterado = caminho.replace("\\build", "");

        try {
            FileInputStream in = (FileInputStream) file.getInputstream();
            FileOutputStream out = new FileOutputStream(caminhoAlterado);

            byte[] buffer = new byte[(int) file.getSize()];
            int contador = 0;

            while ((contador = in.read(buffer)) != -1) {
                out.write(buffer, 0, contador);
            }
            in.close();
            out.close();
            
            

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return controleNome;
    }
    
}
