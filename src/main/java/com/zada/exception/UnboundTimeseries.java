/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.exception;

/**
 *
 * @author bigdata
 */
public class UnboundTimeseries extends RuntimeException {

    public UnboundTimeseries(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
