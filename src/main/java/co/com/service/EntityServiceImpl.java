/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.dao.EntityDao;
import co.com.model.Car;
import co.com.util.RespuestaObject;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public class EntityServiceImpl<T> implements EntityService<T> {

    private Class<T> type;
    private EntityDao dao;

    public EntityServiceImpl(Class<T> classType) {
        type = classType;
        dao = new EntityDao<>(type);
    }

    @Override
    public RespuestaObject insert(T object) {
        Integer id = null;
        if (Car.class.isInstance(object)) {
            Car car = (Car) object;
            id = car.getId();
        }
        return dao.insert(object);
    }

    @Override
    public RespuestaObject update(T object) {
        Integer id = null;
        if (Car.class.isInstance(object)) {
            Car car = (Car) object;
            id = car.getId();
        }
        return dao.update(object);
    }

    @Override
    public RespuestaObject delete(T object, int id) {
        if (Car.class.isInstance(object)) {
            Car car = new Car(id);
            return dao.delete(type);
        }
        return null;
    }

    @Override
    public List<T> selectAll(String table) {
        return dao.getAll(table);
    }

    @Override
    public T selectById(T objectToFind, int id) {
        return (T) dao.getById(objectToFind, id);
    }

}
