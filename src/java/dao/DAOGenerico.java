package dao;


import java.util.List;
import javax.persistence.EntityManager;

public class DAOGenerico {

    private EntityManager em;

    public void inserir(Object obj) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();

    }

    public void alterar(Object obj) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    public void remover(Class classe, Long id) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        Object obj = em.find(classe, id);
        if (obj != null) {
            em.remove(obj);
        }
        em.getTransaction().commit();
    }

    public Object buscarPorId(Class classe, Long id) {
        em = CriarEntityManager.getInstancia().getEm();
        Object retorno = em.find(classe, id);
        return retorno;
    }

    public List listar(Class classe) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName()).getResultList();
        return retorno;
    }

    public List listarCondicao(Class classe, String coluna,String condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where " +coluna+" like '" + condicao + "'").getResultList();
        return retorno;
    }

    public List listarCondic(Class classe, String coluna, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where "+coluna+" = " + id).getResultList();
        return retorno;
    }

    public List listarCondic2(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where evento =" + id).getResultList();
        return retorno;
    }
    
        public List listarCondic3(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where participante =" + id).getResultList();
        return retorno;
    }

    public List listarCondicData(Class classe) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where dataEvento > CURRENT_DATE").getResultList();
        return retorno;
    }
    
        public List listarCondicData2(Class classe, Long id) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where participante =" + id +" and evento.dataEvento > CURRENT_DATE").getResultList();
        return retorno;
    }

    public Object listarCondicString(Class classe, long id) {
        em = CriarEntityManager.getInstancia().getEm();
        Object retorno = em.createQuery("from " + classe.getSimpleName() + " where id=" + id).getSingleResult();
        return retorno;
    }

}
