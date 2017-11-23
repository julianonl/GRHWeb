
package teste;

import dao.DAOGenerico;
import dao.DaoMesReferencia;
import entidade.MesReferencia;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Juliano
 */
public class TesteReferencia {
    
    public static void main(String[] args) {
        MesReferencia m = new MesReferencia();
        DaoMesReferencia dao = new DaoMesReferencia();
        DAOGenerico daog = new DAOGenerico();
        
        //System.out.println(dao.listarMesCondic(m.getClass(), 2));
        
        
        m=(MesReferencia) daog.buscarPorId(MesReferencia.class, 1L);
        Date data = new Date();
        data=m.getDataReferencia();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
       
    }
    
}
