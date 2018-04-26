/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

import com.zada.exception.UnboundTimeseries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author bigdata
 */
public class Difference extends XY {

    private List<Tuple<Object, Number>> tuples;
    private int interval;

    // constructor
    public Difference() {
        super();
    }

    public Difference(Map<? extends Object, ? extends Number> data) {
        super(data);
    }

    @Override
    public <D1 extends Object, D2 extends Number> Map<D1, D2> diff() {
        Map<D1, D2> result = new TreeMap<>();
        for (int i = 0; i < this.getTuples().size(); i++) {
            if (i >= this.interval) {
                Tuple<Object, Number> t1 = this.getTuples().get((i - this.interval));
                Tuple<Object, Number> t2 = this.getTuples().get(i);
                Number dival = (Number) (t2._2().doubleValue() - t1._2().doubleValue());
                result.put((D1) t2._1(), (D2) dival);
            }
        }
        return result;
    }

    public <D extends Number> D inverse(Object time, D diffed) {
        int pIndex = this.getIndex(time) - interval;
        if (pIndex < 0) {
            throw new UnboundTimeseries(String.format("%s is out of bound in timeseries for differencing, check interval", time));
        }
        Number reverseVal = (Number) (diffed.doubleValue() + this.getTuples().get(pIndex)._2().doubleValue());
        return (D) reverseVal;
    }

    public <D1 extends Object, D2 extends Number> Map<D1, D2> inverse(Map<D1, D2> diffedMap) {
        Map<D1, D2> result = new HashMap<>();
        diffedMap.keySet().forEach((time) -> {
            result.put(time, inverse(time, diffedMap.get(time)));
        });
        return result;
    }

    public <D1 extends Number, D2 extends Number> Map<D1, D2> anomaliesConfimation(Map<D1, D2> diffConfirm) {
        Map<D1, D2> result = new HashMap<>();
        diffConfirm.keySet().forEach((time) -> {
            int pIndex = this.getIndex(time) - interval;
            Object diffTime = this.getTuples().get(pIndex)._1();
            if (diffConfirm.get(diffTime) == null) {
                result.put(time, diffConfirm.get(time));
            }
        });
        return result;
    }

    private int getIndex(Object time) {
        int index = 0;
        for (int i = 0; i < this.getTuples().size(); i++) {
            Tuple<Object, Number> tup = this.getTuples().get(i);
            if (tup._1().equals(time)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * @return the tuple
     */
    public List<Tuple<Object, Number>> getTuples() {
        if (this.tuples == null) {
            this.tuples = new ArrayList<>();
            this.getData().keySet().forEach((time) -> {
                this.tuples.add(new Tuple(time, this.getData().get(time)));
            });
        }
        return this.tuples;
    }

    /**
     * @param tuple the tuple to set
     */
    public void setTuple(List<Tuple<Object, Number>> tuple) {
        this.tuples = tuple;
    }

    /**
     * @return the interval
     */
    public int getInterval() {
        return interval;
    }

    /**
     * @param interval the interval to set
     * @return
     */
    public Difference setInterval(int interval) {
        this.interval = interval;
        return this;
    }

}
