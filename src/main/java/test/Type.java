/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bigdata
 * @param <T1>
 * @param <T2>
 */
public class Type<T1, T2> {

    public Type(Map<String, Long> data) {

    }

    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        new Type(data);
    }
}
