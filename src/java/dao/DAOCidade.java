
package dao;

import entidade.Cidade;
import java.util.List;
import javax.persistence.EntityManager;


public class DAOCidade {
    
        private EntityManager em;
         DAOGenerico daoGen = new DAOGenerico();

    public void salvar(Cidade cidade) {

        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.persist(cidade);
        em.getTransaction().commit();
    }

    public void alterar(Cidade cidade) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.merge(cidade);
        em.getTransaction().commit();
    }

    public void remover(Cidade cidade) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.getTransaction().begin();
        em.remove(cidade);
        em.getTransaction().commit();
    }

    public Cidade buscaId(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        Cidade cidade = em.find(Cidade.class, id);
        em.getTransaction().commit();
        
        return cidade;
    }

        public List<Cidade> listaCidade() {
        List<Cidade> cidade=daoGen.listar(Cidade.class);
        return cidade;
    }
        
        
   public Object buscarPorCondicao() {
        em = CriarEntityManager.getInstancia().getEm();
        Object retorno = em.createQuery("from Cidade c where c.nome like Loanda").getSingleResult();
        return retorno;
    }
    
}
