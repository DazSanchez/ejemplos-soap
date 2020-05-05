/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.exceptions;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class QueryExecutionException extends Exception {

    public QueryExecutionException(String msg) {
        super(msg);
    }

    public QueryExecutionException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
