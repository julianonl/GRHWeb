
package dao;

import entidade.Cargo;
import entidade.Cidade;
import java.util.List;
import javax.persistence.EntityManager;


public class DAOCargo {
    
        private EntityManager em;
         DAOGenerico daoGen = new DAOGenerico();


        public List<Cargo> listaCargo() {
        List<Cargo> cargo=daoGen.listar(Cargo.class);
        return cargo;
    }
        
        public List listar() {
        em = CriarEntityManager.getInstancia().getEm();
        List<Cargo> retorno = em.createQuery("from Cargo").getResultList();
        return retorno;
    }
        
        public Cargo buscaId(long id) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        Cargo cargo = em.find(Cargo.class, id);
        em.getTransaction().commit();
        
        return cargo;
    }
        
        

    
}
