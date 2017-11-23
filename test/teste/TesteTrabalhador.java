/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.DAOTrabalhador;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Juliano
 */
public class TesteTrabalhador {

    public static void main(String[] args) {
        DAOTrabalhador daot = new DAOTrabalhador();

        // System.out.println(daot.listarCondicLong(1L).getNome());
        double d = 12.548795;
        BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
        Double c = bd.doubleValue();
        System.out.println(c);

    }

}
