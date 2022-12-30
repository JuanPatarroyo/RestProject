/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.util;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jpatarroyo
 */
public class RespuestaObject<T> {

    private String status;
    private String message;
    private T singleResult;
    private List<T> listResult;
    private Map<String, ?> listValues;

    public RespuestaObject(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public RespuestaObject(String status, String message, T singleResult) {
        this.status = status;
        this.message = message;
        this.singleResult = singleResult;
    }

    public RespuestaObject(String status, String message, List<T> listResult) {
        this.status = status;
        this.message = message;
        this.listResult = listResult;
    }

    public RespuestaObject(String status, Map<String, ?> listValues) {
        this.status = status;
        this.listValues = listValues;
    }

    public RespuestaObject(String status, String message, Map<String, ?> listValues) {
        this.status = status;
        this.message = message;
        this.listValues = listValues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getSingleResult() {
        return singleResult;
    }

    public void setSingleResult(T singleResult) {
        this.singleResult = singleResult;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public Map<String, ?> getListValues() {
        return listValues;
    }

    public void setListValues(Map<String, ?> listValues) {
        this.listValues = listValues;
    }
}
