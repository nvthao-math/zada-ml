/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

import com.zada.exception.UnSupportTimeException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author bigdata
 */
public abstract class XY {

    private TreeMap<Long, Number> data;
    private boolean asc = true;

    // constructor
    public XY() {
        super();
    }

    public XY(Map<? extends Object, ? extends Number> data) {
        this.setData(data);
    }

    public abstract <D1 extends Object, D2 extends Number> Map<D1, D2> diff();

    /**
     * @return the data
     */
    public Map<Long, Number> getData() {
        if (!this.asc) {
            return data.descendingMap();
        }
        return data;
    }

    /**
     * @param data the data to set
     */
    private XY setData(Map<? extends Object, ? extends Number> data) {
        this.data = new TreeMap<>();
        data.forEach((Object key, Number val) -> {
            this.set(key, val);
        });
        return this;
    }

    public XY set(Object key, Number val) {
        isTime(key);
        this.getData().put(Long.parseLong(key.toString()), val);
        return this;
    }

    public <T extends Number> T get(Object time) {
        isTime(time);
        return (T) this.getData().get(Long.parseLong(time.toString()));
    }

    protected void isTime(Object key) {
//        boolean is = false;
        try {
            Long.parseLong(key.toString());
//            is = true;
        } catch (NumberFormatException ignore) {
            throw new UnSupportTimeException("TimeSeries data can not support Key without parsing to Long");
        }
//        if (!is) {
//            throw new UnSupportTimeException("TimeSeries can not support Key without parsing to Long");
//        }
    }

    /**
     * @return the asc
     */
    public boolean isAsc() {
        return asc;
    }

    /**
     * @param asc the asc to set
     * @return
     */
    public XY setAsc(boolean asc) {
        this.asc = asc;
        return this;
    }

}
