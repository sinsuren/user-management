package com.sinsuren.user.management.model.dao.impl;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by surender.s on 15/10/17.
 */
public abstract class AbstractDao <E , P> {
    @Getter
    @PersistenceContext
    public EntityManager entityManager;
    @Getter
    private Class<E> entityClass;

    public AbstractDao(EntityManager entityManager, Class<E> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public E findById(P id) {
        return entityManager.find(getEntityClass(), id);
    }

    protected E insert(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    protected List<E> insert(List<E> entities) {
        List<E> result = new ArrayList<E>();

        if (entities == null) {
            return result;
        }

        for (E entity : entities) {
            result.add(insert(entity));
        }

        return result;
    }

}
