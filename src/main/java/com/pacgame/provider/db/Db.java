package com.pacgame.provider.db;

import com.pacgame.provider.exception.DuplicateEntityException;
import com.pacgame.provider.exception.EntityNotFoundException;
import com.pacgame.provider.exception.UnsupportedEntityException;

public interface Db {

    <T extends Entity> T  save(T entity) throws DuplicateEntityException, UnsupportedEntityException;

    <T extends Entity> void delete(T entity) throws EntityNotFoundException, UnsupportedEntityException;

    <T extends Entity> T findById(Class<T> clazz , int id) throws EntityNotFoundException, UnsupportedEntityException;
}
