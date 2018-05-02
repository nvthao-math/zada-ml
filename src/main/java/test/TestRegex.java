/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bigdata
 */
public class TestRegex {

    public static void main(String[] args) {
        Object[] entities = {"messi", "ronaldo", "neymar", "ozil"};
        String line = "@@ và @@ abcxyz @@ @@";
        String pattern = line.replaceAll("@@", "%s");
        String newLine = String.format(pattern, entities);
        System.out.println(line);
        System.out.println(newLine);
    }

}
