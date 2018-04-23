/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

/**
 *
 * @author bigdata
 */
public enum TType {

    YEARLY("yearly"), MONTHLY("monthly"), WEEKLY("weekly"), DAILY("daily"), HOURLY("hourly"), MINUTELY("minutely");

    private String name;

    private TType(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
