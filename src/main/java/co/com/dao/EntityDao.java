/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.dao;

import static co.com.dao.ConfigurationDao.em;
import co.com.util.RespuestaObject;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jpatarroyo
 */
public class EntityDao<T> extends ConfigurationDao {

    private Class<T> type;

    public EntityDao(Class<T> typeClass) {
        type = typeClass;
    }

    public List<T> getAll(String table) {
        String sql = "SELECT " + table.substring(0, 1) + " FROM " + table + " " + table.substring(0, 1);
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public RespuestaObject insert(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return new RespuestaObject("OK", "Registro insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new RespuestaObject("ERROR", "Error insertando registro " + e.getMessage());
        }
    }

    public RespuestaObject update(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return new RespuestaObject("OK", "Registro actualizado correctamente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new RespuestaObject("ERROR", "Error actualizando registro " + e.getMessage());
        }
    }

    public RespuestaObject delete(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(object));
            em.getTransaction().commit();
            return new RespuestaObject("OK", "Registro eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new RespuestaObject("ERROR", "Error eliminando registro " + e.getMessage());
        }
    }

    public T getById(T object, Integer idObject) {
        em = getEntityManager();
        return em.find(type, idObject);
    }
}
