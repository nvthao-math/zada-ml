///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package test;
//
//import ij.*;
//import ij.gui.*;
//import ij.plugin.PlugIn;
//import java.awt.*;
//import ij.gui.Plot;
//
///**
// *
// * @author bigdata
// */
//public class Example_Plots implements PlugIn {
//
//    public void run(String arg) {
//        if (IJ.versionLessThan("1.47r")) {
//            return;
//        }
//
//        // First plot (log-log)
//        logPlot(true);
//
//        // Second plot (semi-log)
//        logPlot(false);
//
//        // Third plot (vector plot)
//        // for details on the plotted data, see: http://www.thphys.uni-heidelberg.de/~biophys/index.php?lang=e&n1=research_elasticsubstrates
//        // definition of the plot
//        double[] X0 = {113.7700, 88.7468, 56.4684, 30.2856, 3.0181, -27.8690, -58.7503, -84.5998, -118.5439, -114.1901, -91.5908, -59.0922, -32.4929, -3.0302, 27.7297, 60.1355, 86.4298, 113.9279, 116.0125, 116.9311, 115.2122, 113.6640, 114.0277, 113.3385, 111.7978, -113.2085, -113.7728, -112.8976, -116.5197, -115.1823, -114.6198, -116.1608};
//        double[] Y0 = {274.9993, 287.5826, 294.7450, 304.6684, 296.8976, 299.4591, 298.1470, 288.9624, 277.5624, -277.6678, -290.2371, -292.4418, -300.0705, -298.5476, -298.2827, -297.7287, -288.1574, -276.4060, 209.0291, 139.2655, 70.3950, -2.0079, -66.5041, -137.0845, -208.1839, 207.9907, 139.6942, 69.1772, -0.2823, -68.2797, -137.1580, -203.4029};
//        double[] X1 = {110.6666, 94.9703, 51.9864, 35.9185, 9.3894, -14.1362, -57.0487, -81.1059, -122.4320, -110.9916, -85.8011, -60.6314, -25.2819, -3.4490, 21.7950, 65.9892, 79.7254, 116.0447, 116.8159, 106.2246, 116.9016, 121.4979, 114.5718, 119.2102, 111.4324, -102.2677, -116.7686, -116.5609, -107.1415, -123.3424, -109.6162, -120.9915};
//        double[] Y1 = {198.9581, 210.0830, 199.6933, 242.2593, 193.5970, 214.9658, 182.6873, 215.2335, 187.4883, -193.7738, -223.1216, -190.4850, -212.6556, -196.0658, -221.6859, -203.9979, -207.9261, -202.5154, 198.9013, 127.2264, 78.6060, -12.7671, -56.9279, -146.0858, -181.7953, 188.8955, 139.1794, 89.0138, -13.2297, -59.7313, -130.7629, -172.8975};
//        double[] X2 = {110.9858, 90.8875, 59.7368, 35.1602, 8.7212, -15.0744, -68.8493, -84.1148, -112.1478, -112.3861, -83.4511, -53.4834, -30.8445, -3.3701, 25.6300, 64.9645, 87.7592, 110.5075, 116.0125, 116.9311, 115.2122, 113.6640, 114.0277, 113.3385, 111.7978, -113.2085, -113.7728, -112.8976, -116.5197, -115.1823, -114.6198, -116.1608};
//        double[] Y2 = {161.1220, 228.7408, 158.9232, 243.9628, 172.3519, 230.1003, 171.0518, 225.1697, 157.7803, -141.1552, -231.9964, -168.3248, -231.6465, -165.7466, -225.0577, -172.2832, -220.6194, -156.0635, 209.0291, 139.2655, 70.3950, -2.0079, -66.5041, -137.0845, -208.1839, 207.9907, 139.6942, 69.1772, -0.2823, -68.2797, -137.1580, -203.4029};
//        Plot plot4 = new Plot("Vector Plot", "X Axis", "Y Axis");
//        plot4.setLimits(-200, 200, -350, 350);
//        plot4.setSize(600, 600);
//        // add red boxes
//        plot4.setColor(Color.red);
//        plot4.setLineWidth(2);
//        plot4.addPoints(X0, Y0, Plot.BOX);
//        // add blue and black arrows
//        plot4.setColor(Color.blue);
//        plot4.setLineWidth(1);
//        plot4.drawVectors(X0, Y0, X1, Y1);
//        plot4.setColor(Color.black);
//        plot4.drawVectors(X0, Y0, X2, Y2);
//        plot4.show();
//
//        // Fourth plot (multiple curves with error bars)
//        float[] x = {0.1f, 0.25f, 0.35f, 0.5f, 0.61f, 0.7f, 0.85f, 0.89f, 0.95f}; // x-coordinates
//        float[] y = {2f, 5.6f, 7.4f, 9f, 9.4f, 8.7f, 6.3f, 4.5f, 1f}; // x-coordinates
//        float[] e = {.8f, .6f, .5f, .4f, .3f, .5f, .6f, .7f, .8f}; // error bars
//        Plot plot = new Plot("Error Bars", "X Axis", "Y Axis", x, y);
//        plot.setLimits(0, 1, 0, 10);
//        plot.setLineWidth(2);
//        plot.addErrorBars(e);
//        // add a second curve
//        double x2[] = {0.4, .5, .6, .7, .8};
//        double y2[] = {4, 3, 3, 4, 5};
//        double e2[] = {1.0, 1.3, 2.0, 1.0, 1.1};
//        plot.setColor(Color.red);
//        plot.addPoints(x2, y2, Plot.X);
//        plot.addPoints(x2, y2, e2, Plot.LINE);
//        // add label
//        plot.setColor(Color.black);
//        plot.changeFont(new Font("Helvetica", Font.PLAIN, 18));
//        plot.addLabel(0.02, 0.12, "Plots can now have\nmultiple curves\nwith error bars.");
//        plot.setColor(Color.blue);
//        plot.show();
//    }
//
//    void logPlot(boolean logLog) {
//        int n = 1000;
//        double[] x = new double[n];
//        double[] y = new double[n];
//        double[] y2 = new double[n];
//        double[] y3 = new double[n];
//        for (int i = 0; i < n; i++) {
//            double v = 0.1 + i * 0.1;
//            x[i] = v;
//            y[i] = v;
//            y2[i] = v * v;
//            y3[i] = v * v * v;
//        }
//        String title = logLog ? "Log-log Plot" : "Semi-log Plot";
//        Plot plot = new Plot(title, "X Axis", "Y Axis");
//        plot.setLogScaleX();
//        if (logLog) {
//            plot.setLogScaleY();
//        }
//        plot.setLimits(0.1, n / 10, 0.1, n / 10);
//        plot.setSize(500, 500);
//        plot.setLineWidth(2);
//        plot.setColor(Color.blue);
//        plot.addPoints(x, y, Plot.LINE);
//        plot.setColor(Color.green);
//        plot.addPoints(x, y2, Plot.LINE);
//        plot.setColor(Color.red);
//        plot.addPoints(x, y3, Plot.LINE);
//        plot.setJustification(Plot.RIGHT);
//        double xloc = 0.2;
//        double yloc = 0.07;
//        plot.setColor(Color.black);
//        plot.addLabel(xloc, yloc, "y = x^3");
//        plot.addLabel(xloc, yloc + 0.04, "y = x^2");
//        plot.addLabel(xloc, yloc + 0.08, "y = x");
//        xloc += 0.01;
//        yloc -= 0.01;
//        plot.setColor(Color.red);
//        plot.drawNormalizedLine(xloc, yloc, xloc + 0.1, yloc);
//        plot.setColor(Color.green);
//        plot.drawNormalizedLine(xloc, yloc + 0.04, xloc + 0.1, yloc + 0.04);
//        plot.setColor(Color.blue);
//        plot.drawNormalizedLine(xloc, yloc + 0.08, xloc + 0.1, yloc + 0.08);
//        plot.show();
//    }
//}
