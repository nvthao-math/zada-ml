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
public class XY {

    private Map<Long, Number> data;

    // constructor
    public XY() {
        super();
    }

    public XY(Map<? extends Object, ? extends Number> data) {
        this.setData(data);
    }

    /**
     * @return the data
     */
    public Map<Long, Number> getData() {
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
        try {
            Long.parseLong(key.toString());
        } catch (NumberFormatException ignore) {
            throw new UnSupportTimeException("TimeSeries data can not support Key without parsing to Long");
        }
    }

}
