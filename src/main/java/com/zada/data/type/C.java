/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

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

    public boolean isEmpty() {
        return this.getData().isEmpty();
    }

    public <T extends Number> T min() {
        T min = null;
        Object sample = this.getData().get(0);
        if (sample instanceof Number) {
            min = (T) sample;
            for (D ob : this.getData()) {
                T obt = (T) ob;
                if (obt.doubleValue() < min.doubleValue()) {
                    min = obt;
                }
            }
        }
        return min;
    }

    public <T extends Number> T max() {
        T max = null;
        Object sample = this.getData().get(0);
        if (sample instanceof Number) {
            max = (T) sample;
            for (D ob : this.getData()) {
                T obt = (T) ob;
                if (obt.doubleValue() > max.doubleValue()) {
                    max = obt;
                }
            }
        }
        return max;
    }

    @Override
    public String toString() {
        String info = String.format("%s: %s", this.getName(), this.getData());
        return info;
    }

}
