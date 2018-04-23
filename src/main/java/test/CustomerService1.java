/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bigdata
 */
public class CustomerService1 {

    public static void main(String[] args) {

        CustomerService obj = new CustomerService();

        //create 100 size
        List<String> data = new ArrayList<>(Collections.nCopies(100, "mkyong"));

        obj.analyze(data);

    }

}
