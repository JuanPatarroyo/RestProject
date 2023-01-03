/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.util.RespuestaObject;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public interface EntityService <T> {
    
    RespuestaObject insert(T object);
    RespuestaObject update(T object);
    RespuestaObject delete (T object, int id);
    List<T> selectAll(String table);
    T selectById(T objectToFind, int id);
}
