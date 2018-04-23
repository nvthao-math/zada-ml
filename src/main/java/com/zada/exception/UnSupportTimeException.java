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
public class UnSupportTimeException extends RuntimeException { // RuntimeException

    public UnSupportTimeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
