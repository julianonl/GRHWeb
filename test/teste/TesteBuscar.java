
package teste;

import dao.DAOCnpj;
import dao.DAOGenerico;
import entidade.Cnpj;
import entidade.Empregador;
import java.util.ArrayList;
import java.util.List;


public class TesteBuscar {
    
    public static void main(String args[]){
    
        DAOGenerico dao = new DAOGenerico();
        DAOCnpj daoc = new DAOCnpj();
        Cnpj cnpj = new Cnpj();
        Empregador e = new Empregador();
        
       e= daoc.listarCondicString("11.111.111/1111-11");
        
        System.out.println("cnpj "+e.getCnpj().getCnpj());
        
        
        List<Cnpj> cnpjs = new ArrayList<Cnpj>();
        cnpjs=dao.listarCondicao(cnpj.getClass(), "cnpj", "12.730.287/0001-94");
        
        for (Cnpj cnpj1 : cnpjs) {
            System.out.println(cnpj1.getCnpj());
            
        }
//        
        List<Empregador> emp = new ArrayList<Empregador>();
        emp=daoc.listarCondicao("12.730.287/0001-94");
        
        for (Empregador empregador : emp) {
            System.out.println("Cnpj: "+empregador.getCnpj().getCnpj());
            
        }
    
    }
    
}
