package com.pacgame.provider.db.repository;


import com.pacgame.provider.db.Db;
import com.pacgame.provider.db.DbRepository;
import com.pacgame.provider.db.LayerEntity;
import com.pacgame.provider.exception.DuplicateEntityException;
import com.pacgame.provider.exception.EntityNotFoundException;
import com.pacgame.provider.exception.UnsupportedEntityException;

public class LayerRepository implements DbRepository<LayerEntity> {

    private Db db;

    public LayerRepository(Db db) {
        this.db = db;
    }

    @Override
    public LayerEntity save(LayerEntity entity)  {
        LayerEntity saveEntity = null;

        try {
            saveEntity = db.save(entity);

        } catch (UnsupportedEntityException e) {
            System.out.println("Entity " + entity.getClass().toString() + " class can not be save");
        } catch (DuplicateEntityException e) {
            System.out.println("Entity " + entity.getClass().toString() + " class can not be save again");
        }

        return saveEntity;

    }

    @Override
    public void delete(LayerEntity entity)  {

        try {
            db.delete(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Entity " + entity.getClass().toString() + " class and id " + entity.getId() + " not found");
        } catch (UnsupportedEntityException e) {
            System.out.println("Entity " + entity.getClass().toString() + " class can not be delete because this operation is not supported");
        }
    }

    @Override
    public LayerEntity findById(Class<LayerEntity> clazz, int id) {
            LayerEntity layerEntity = null;
        try {
            layerEntity = db.findById(clazz, id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEntityException e) {
            e.printStackTrace();
            System.out.println("Entity " + clazz.toString() + " class can not be find because this operation is not supported");
        }

        return layerEntity;
    }
}
