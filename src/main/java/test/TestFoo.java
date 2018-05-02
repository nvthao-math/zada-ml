/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.reflect.Field;

/**
 *
 * @author bigdata
 */
public class TestFoo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setX(12);

        Class<?> c = foo.getClass();
        for (Field field : c.getFields()) {
            try {
                System.out.println(field.getName() + "= " + field.get(foo).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
