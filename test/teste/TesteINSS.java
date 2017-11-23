/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.DAOInss;
import entidade.TabelaINSS;


public class TesteINSS {
    
    public static void main(String[] args) {
        TabelaINSS m = new TabelaINSS();
        DAOInss dao = new DAOInss();
        
        
        System.out.println(dao.listarInss(m.getClass(), 2));
       
    }
    
}
