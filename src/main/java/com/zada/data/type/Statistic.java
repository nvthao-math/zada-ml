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
public interface Statistic {

    <T extends Number> T arithmeticMean();

    <T extends Number> T harmonicMean();

    <T extends Number> T median();

    <T extends Number> T mode();

    <T extends Number> T range();

    <T extends Number> T quantile();

    <T extends Number> T meanAbsoluteDeviation();

    <T extends Number> T variance();

    <T extends Number> T standardDeviation();

    <T extends Number> T coefficientOfVariation();

}
