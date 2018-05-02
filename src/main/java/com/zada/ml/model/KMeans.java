/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.ml.model;

import java.util.Map;

/**
 *
 * @author bigdata
 */
public class KMeans {

//    private Map<? extends Number, ? extends Number> originData;
//    private Double iqrThreshold;
//    private Double iqrBottomClusterThreshold;
//    private Double iqrTopClusterThreshold;
//    private Double chevbyshevThreshold;
    private Map<? extends Number, ? extends Number> data;
    private Integer numberOfCluster;

    public KMeans(Map<? extends Number, ? extends Number> data) {
        this.data = data;
    }

    public KMeans(Map<? extends Number, ? extends Number> data, int numberOfCluster) {
        this.data = data;
        this.numberOfCluster = numberOfCluster;
    }

}
