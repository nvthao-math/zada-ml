/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;

/**
 *
 * @author bigdata
 */
public class CustomerService {

    public Customer findByName(String name) throws NameNotFoundException {

        if ("".equals(name)) {
            throw new NameNotFoundException("Name is empty!");
        }

        return new Customer(name);

    }

    public void analyze(List<String> data) {

        if (data.size() > 50) {
            //runtime exception
            throw new ListTooLargeException("List can't exceed 50 items!");
        }

        //...
    }

    public static void main(String[] args) {

        CustomerService obj = new CustomerService();
//        obj.findByName("");
        try {

            Customer cus = obj.findByName("");

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
