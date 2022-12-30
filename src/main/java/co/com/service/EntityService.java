/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.util.RespuestaObject;

/**
 *
 * @author jpatarroyo
 */
public interface EntityService <T> {
    
    RespuestaObject<T> insert(T object);
    RespuestaObject<T> update(T object);
    RespuestaObject<T> delete (int id);
    RespuestaObject<T> selectAll();
    RespuestaObject<T> selectById(int id);
}
