/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

import com.bake.time.EUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bigdata
 * @param <D>
 */
public class C<D> {

    private List<D> data;
    private String name;

    // constructor
    public C() {
        super();
    }

    public C(D... vals) {
        if (vals != null) {
            this.data = new ArrayList<>(Arrays.asList(vals));
        } else {
            throw new RuntimeException("Null pointer exception");
        }
    }

    public C(List<D> vals) {
        if (vals != null) {
            this.data = new ArrayList<>(vals);
        } else {
            throw new RuntimeException("Null pointer exception");
        }
    }

    public C(List<D> vals, String name) {
        this.name = name;
        if (vals != null) {
            this.data = new ArrayList<>(vals);
        } else {
            throw new RuntimeException("Null pointer exception");
        }
    }

    /**
     * @return the data
     */
    private List<D> getData() {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        return this.data;
    }

    /**
     * @param data the data to set
     */
    protected void setData(List<D> data) {
        this.data = data;
    }

    public void addData(D val) {
        this.getData().add(val);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @return
     */
    public C setName(String name) {
        this.name = name;
        return this;
    }

    public void sort() {
        Collections.sort((List) this.getData());
    }

    public C coppy() {
        return new C(this.getData());
    }

    public int size() {
        return this.getData().size();
    }

    public D get(int index) {
        return this.getData().get(index);
    }

    public static void main(String[] args) throws NoSuchFieldException {
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        Integer[] itn = {1, 2, 3, 4, 6, 8};
//        C c = new C(list);
//        c.addData(1000);
        List<String> list = new ArrayList<>();
        list.add("seas");
        list.add("fft1");
        C vec = new C(list);
//        vec.clone();
        System.out.println(EUtils.toJson(vec));
        //
//        Object foo = new Object();
// There's no support for this
//        String name = foo.getName(); // expecting to get "foo"
        System.out.println(vec);
        String name = vec.getClass().getCanonicalName();
        System.out.println(name);
        Field[] fields = vec.getClass().getDeclaredFields();
        for (Field f : fields) {

            System.out.println(f.getName());
        }
        //
        for (Field f : vec.getClass().getFields()) {
            System.out.println(f.getName());
        }
        vec.getClass().getFields();
    }

}
