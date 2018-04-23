/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author bigdata
 */
public class NameNotFoundException extends Exception {

    public NameNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
