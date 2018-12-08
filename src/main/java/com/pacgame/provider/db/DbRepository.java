package com.pacgame.provider.db;

import com.pacgame.provider.exception.DuplicateEntityException;
import com.pacgame.provider.exception.EntityNotFoundException;
import com.pacgame.provider.exception.UnsupportedEntityException;

public interface DbRepository<T extends Entity> {

    T save(T entity) ;

    void delete(T entity) ;

    T findById(Class<T> clazz , int id) ;

}
