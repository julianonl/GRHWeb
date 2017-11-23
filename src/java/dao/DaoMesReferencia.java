
package dao;

import entidade.MesReferencia;
import javax.persistence.EntityManager;


public class DaoMesReferencia {
    
        private EntityManager em;
    
        public MesReferencia listarMesCondic(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        MesReferencia retorno = (MesReferencia) em.createQuery("from " + classe.getSimpleName() + " where empregador_id=" + id).getSingleResult();
        return retorno;
    }
    
}
