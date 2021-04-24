package com.enterprise.insurance.core.data;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static PersistenceManager instance;
    @Getter
    private EntityManager entityManager;

    private PersistenceManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.enterprise.insurance.persistence");
        entityManager = emf.createEntityManager();
        beginTransaction();
    }

    public static synchronized PersistenceManager getInstance(){
        if(instance == null){
            instance = new PersistenceManager();
        }
        return instance;
    }

    protected void rollbackTransaction(){
        entityManager.getTransaction().rollback();
    }

    protected void beginTransaction(){
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
    }

    protected void commitBeginTransaction(){
        entityManager.getTransaction().commit();
    }
}
