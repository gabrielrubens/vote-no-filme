package br.com.gabrielrubens.filme.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class Repository<T, I extends Serializable> {
	protected EntityManager entityManager;
	protected Class<T> clazz;
    
    @Deprecated
    public Repository(){
    }
    
    @Inject
    protected Repository(EntityManager entityManager) {
		this.entityManager = entityManager;
		@SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        this.clazz = clazz;
    }
    
	public T find(I id) {
		return (T) entityManager.find(clazz, id);
	}
}
