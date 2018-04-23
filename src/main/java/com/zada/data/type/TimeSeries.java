/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

import com.bake.time.TimeUtils;
import com.zada.exception.UnSupportTimeException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author bigdata
 */
public class TimeSeries {

    private Map<Long, Number> data;
    private TType type;
    private Map<Integer, Map<Long, Number>> partitionedData;

    // constructor
    public TimeSeries() {
        super();
    }

    /**
     *
     * @param data
     */
    public TimeSeries(Map<? extends Object, ? extends Number> data) {
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
    private TimeSeries setData(Map<? extends Object, ? extends Number> data) {
        this.data = new TreeMap<>();
        data.forEach((Object key, Number val) -> {
            this.set(key, val);
        });
        return this;
    }

    public TimeSeries set(Object key, Number val) {
        isTime(key);
        this.getData().put(Long.parseLong(key.toString()), val);
        return this;
    }

    public <T extends Number> T get(Object time) {
        isTime(time);
        return (T) this.getData().get(Long.parseLong(time.toString()));
    }

    private void isTime(Object key) {
        boolean is = false;
        try {
            Long.parseLong(key.toString());
            is = true;
        } catch (NumberFormatException ignore) {
        }
        if (!is) {
            throw new UnSupportTimeException("TimeSeries can not support Key without parsing to Long");
        }
    }

    /**
     * @return the type
     */
    public TType getType() {
        return type;
    }

    /**
     * @param type the type to set
     * @return
     */
    public TimeSeries setType(TType type) {
        this.type = type;
        return this;
    }

    public Map<Long, Number> getPartitionedData(TType type, Object time) throws Exception {
        isTime(time);
        long ltime = Long.parseLong(time.toString());
        this.type = type;
        return this.getPartitionedData(ltime);
    }

    private int getTimeType(long time) throws Exception {
        int timeVal = 0;
        switch (this.type) {
            case YEARLY:
                timeVal = TimeUtils.getYear(time);
                break;
            case MONTHLY:
                timeVal = TimeUtils.getMonth(time);
                break;
            case WEEKLY:
                timeVal = TimeUtils.getDay(time);
                break;
            case DAILY:
                timeVal = TimeUtils.getDate(time);
                break;
            case HOURLY:
                timeVal = TimeUtils.getHour(time);
                break;
            case MINUTELY:
                timeVal = TimeUtils.getMinutes(time);
                break;
            default:
                break;
        }
        return timeVal;
    }

    private Map<Integer, Map<Long, Number>> partioning() {
        this.partitionedData = new TreeMap<>();
        this.getData().forEach((Long time, Number val) -> {
            try {
                int ttime = getTimeType(time);
                Map<Long, Number> cabin = this.partitionedData.get(ttime);
                if (cabin == null) {
                    cabin = new TreeMap<>();
                }
                cabin.put(time, val);
                this.partitionedData.put(ttime, cabin);
            } catch (Exception ex) {
                throw new RuntimeException(ex.toString());
            }
        });
        return this.partitionedData;
    }

    /**
     * @return the partitionedData
     */
    public Map<Integer, Map<Long, Number>> getPartitionedData() throws Exception {
        return partioning();
    }

    public Map<Long, Number> getPartitionedData(long time) throws Exception {
        int ttime = getTimeType(time);
        return partioning().get(ttime);
    }

    /**
     * @param partitionedData the partitionedData to set
     */
    public void setPartitionedData(Map<Integer, Map<Long, Number>> partitionedData) {
        this.partitionedData = partitionedData;
    }

}
