package dao;

import entidade.TabelaINSS;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Juliano
 */
public class DAOInss {

    private EntityManager em;

    public TabelaINSS listarInss(Class classe, long id) {

        try {
            em = CriarEntityManager.getInstancia().getEm();
            TabelaINSS retorno = (TabelaINSS) em.createQuery("from " + classe.getSimpleName() + " where empregador_id=" + id).getSingleResult();
            return retorno;
        } catch (NoResultException nre) {
            return null;

        }

    }
}
