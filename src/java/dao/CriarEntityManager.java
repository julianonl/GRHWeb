package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.internal.EntityManagerImpl;   

public class CriarEntityManager {

    private static CriarEntityManager criarem;
    private EntityManager em;

    public CriarEntityManager() {
        em = Persistence.createEntityManagerFactory("Projeto_Web_RHPU").createEntityManager();
    }

    public static CriarEntityManager getInstancia() {
        if (criarem == null) {
            criarem = new CriarEntityManager();
            System.out.println("criado");
        }
        return criarem;
    }

    public EntityManager getEm() {
        return em;
    }

    public Connection getConnection() {
        EntityManagerImpl factory = (EntityManagerImpl) em;
        SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory.getSession().getSessionFactory();
        try {
            return sessionFactoryImpl.getConnectionProvider().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CriarEntityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
