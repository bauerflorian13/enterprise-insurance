package com.enterprise.insurance.core.data;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static PersistenceManager instance;
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Getter
    private Session session;
    @Getter
    private EntityManager entityManager;

    private PersistenceManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.enterprise.insurance.persistence");
        entityManager = emf.createEntityManager();
        createSession();
        session.beginTransaction();
    }

    public static synchronized PersistenceManager getInstance(){
        if(instance == null){
            instance = new PersistenceManager();
        }
        return instance;
    }

    protected void createSession(){
        session = sessionFactory.openSession();
    }

    protected void closeSession(){
        session.close();
    }

    protected void beginTransaction(){
        session.beginTransaction();
    }

    protected void commitBeginTransaction(){
        session.beginTransaction();
        session.getTransaction().commit();
    }
}
