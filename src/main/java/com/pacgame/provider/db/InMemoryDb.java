package com.pacgame.provider.db;

import com.pacgame.provider.exception.DuplicateEntityException;
import com.pacgame.provider.exception.EntityNotFoundException;
import com.pacgame.provider.exception.UnsupportedEntityException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDb implements Db {


    private Map<Integer, LayerEntity> layers;
    private Map<Integer, ShapeEntity> shapes;
    private Map<Integer, UIElementEntity> uiElements;
    private Map<Integer, PaintEntity> paints;

    public InMemoryDb() {
        layers = new HashMap<>();
        shapes = new HashMap<>();
        uiElements = new HashMap<>();
        paints = new HashMap<>();
    }

    @Override
    public Entity save(Entity entity) throws DuplicateEntityException, UnsupportedEntityException {
        Map<Integer, Entity> map = getMapFromEntity(entity);
        if (map.containsKey(entity.getId())) {
            throw new DuplicateEntityException();
        }

        map.put(entity.getId(), entity);

        return entity;

    }

    @Override
    public void delete(Entity entity) throws EntityNotFoundException, UnsupportedEntityException {
        Map<Integer, Entity> map = getMapFromEntity(entity);
        if (!map.containsKey(entity.getId())) {
            throw new EntityNotFoundException();
        }

        map.remove(entity.getId());
    }

    @Override
    public <T extends Entity> T findById(Class<T> clazz, int id) throws EntityNotFoundException, UnsupportedEntityException {
        Map<Integer, Entity> map = getMapFromClass(clazz);

        return (T) map.get(id);
    }

    private Map<Integer, Entity> getMapFromEntity(Entity entity) throws UnsupportedEntityException {
        if (entity instanceof LayerEntity) {
            return new HashMap<>(layers);
        } else if (entity instanceof ShapeEntity) {
            return new HashMap<>(shapes);

        } else if (entity instanceof UIElementEntity) {
            return new HashMap<>(uiElements);
        }
        else if (entity instanceof PaintEntity) {
            return new HashMap<>(paints);
        }

        throw new UnsupportedEntityException();
    }

    private Map<Integer, Entity> getMapFromClass(Class<? extends Entity> clazz) throws UnsupportedEntityException {
        if (clazz.equals(LayerEntity.class)) {
            return new HashMap<>(layers);
        } else if (clazz.equals(ShapeEntity.class)) {
            return new HashMap<>(shapes);

        } else if (clazz.equals(UIElementEntity.class)) {
            return new HashMap<>(uiElements);
        } else if (clazz.equals(PaintEntity.class)) {
            return new HashMap<>(paints);
        }

        throw new  UnsupportedEntityException();
    }


}
