/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.bake.time.EUtils;
import com.zada.data.type.C;
import com.zada.data.type.DataFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bigdata
 */
public class TestDataFrame {

    public static void main(String[] args) {
//        List<Number> lx0 = Arrays.asList(3, 1, 8, 7);
//        C c0 = new C(lx0, "id");
////        List<String> lx1 = Arrays.asList("Chuc", "Khoa", "Nguyet", "Minh");
//        List<Number> lx1 = Arrays.asList(21.0, 21.0, 85.0, 79.0);
//        C c1 = new C(lx1, "name");
//        DataFrame df = new DataFrame(c0, c1);
//        System.out.println("df: " + EUtils.toJson(df));
//        C<Integer> cl = df.getColumn(c0.getName());
//        System.out.println(EUtils.toJson(cl));
//        C<Double> clx = df.getColumn(c1.getName());
//        System.out.println(EUtils.toJson(clx));
//        //
//        System.out.println(df.toString(0, 2));
//        System.out.println("-----------------------------");
//        System.out.println(df);
//        //
//        C cp = new C(Arrays.asList(), "test");
//        System.out.println("empty ? " + cp.isEmpty());
//        System.out.println(cp.toString());
//        //
//        //
//        Integer x = 10;
//        Number x1 = get(x);
//        System.out.println(x1.intValue());
        //
        //
        //
//        List<Double> list = Arrays.asList(1.2, 2.2, 4.2, 12.0, 4.5);
        List<Integer> list = Arrays.asList(1, 2, 4, 12, 4);
        C<Integer> ci = new C(list);
        int minci = ci.min();
        System.out.println(minci);
        int maxci = ci.max();
        System.out.println(maxci);
    }

    public static <T extends Number> T get(T x) {
        T result = null;
        if (x instanceof Number) {
            result = (T) (Number) (x.doubleValue() * 1000);
        }
        return result;
    }

}
