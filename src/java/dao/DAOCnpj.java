package dao;

import entidade.Cnpj;
import entidade.Empregador;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOCnpj {

    private EntityManager em;

    public List listarCondicao(String condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from Empregador where cnpj.cnpj like '" + condicao + "'").getResultList();
        return retorno;
    }

    public Empregador listarCondicString(String condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        Empregador retorno = (Empregador) em.createQuery("from Empregador where cnpj.cnpj like '" + condicao + "'").getSingleResult();
        return retorno;
    }

}
