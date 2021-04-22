package com.enterprise.insurance.core.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class AbstractDAO<E extends AbstractEntity> {

    private final PersistenceManager pm = PersistenceManager.getInstance();
    private Class<E> type;

    @PersistenceContext
    protected EntityManager em;

    public AbstractDAO(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        em = pm.getEntityManager();
    }

    public final E save(E entity){
        em.persist(entity);
        return entity;
    }

    public final void save(Collection<E> entities){
        entities.forEach(this::save);
    }


    public final E getById(long id){
        return (E) pm.getSession().get(type, id);
    }

}
