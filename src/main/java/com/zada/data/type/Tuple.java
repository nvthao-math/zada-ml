/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

/**
 *
 * @author bigdata
 * @param <T1>
 * @param <T2>
 */
public class Tuple<T1, T2> {

    private T1 _1;
    private T2 _2;

    // constructor
    public Tuple() {
        super();
    }

    public Tuple(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    /**
     * @return the _1
     */
    public T1 _1() {
        return _1;
    }

    /**
     * @param _1 the _1 to set
     */
    public void set1(T1 _1) {
        this._1 = _1;
    }

    /**
     * @return the _2
     */
    public T2 _2() {
        return _2;
    }

    /**
     * @param _2 the _2 to set
     */
    public void set2(T2 _2) {
        this._2 = _2;
    }

    @Override
    public String toString() {
        return String.format("_1: %s, _2: %s", this._1, this._2);
    }

}
