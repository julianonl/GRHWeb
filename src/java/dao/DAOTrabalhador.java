/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cidade;
import entidade.Empregador;
import entidade.Trabalhador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juliano
 */
public class DAOTrabalhador {

    private EntityManager em;

    public List listarCondicao(Long condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from Trabalhador where empregador =" + condicao).getResultList();
        return retorno;
    }

    public List listarCondicaoString(String condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from Trabalhador where nome like '" + condicao + "'").getResultList();
        return retorno;
    }

    public List listarCondicaoLongString(Long condicao1, String condicao2) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from Trabalhador where nome like '" + condicao2 + "' and empregador =" + condicao1).getResultList();
        return retorno;
    }
    
        public List listarAtivos(Long condicao1) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from Trabalhador where estatus IN ('ATIVO', 'FÉRIAS', 'AFASTADO') and empregador =" + condicao1).getResultList();
        return retorno;
    }

    public Trabalhador listarCondicLong(Long condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        Trabalhador retorno = (Trabalhador) em.createQuery("from Trabalhador where empregador =" + condicao).getSingleResult();
        return retorno;
    }

    public Trabalhador buscaId(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        Trabalhador trabalhador = em.find(Trabalhador.class, id);
        em.getTransaction().commit();

        return trabalhador;
    }

}
