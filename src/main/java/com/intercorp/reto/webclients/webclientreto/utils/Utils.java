package com.intercorp.reto.webclients.webclientreto.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    
    private static final double LIFE_EXPENTANCY = 78;

    public static String calculate(int age) {
        Double anhosRestante = ( LIFE_EXPENTANCY - age);
        System.out.println("anhos restantes"+anhosRestante);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, anhosRestante.intValue());

        return  String.valueOf(calendar.get(Calendar.YEAR));
    }


    public static double process(int[] list) {
        float average = getAverage(list);
        double variance = getVariance(list, average);
        return (Math.sqrt(variance) > 0 ) ? Math.sqrt(variance) : 0.0 ;
    }
    
    public static float getAverage(int[] list) {
        float sum = 0;
        for(int i=0; i < list.length; i++) {
            sum += list[i];
        }
        return sum/list.length;
    }

    private static double getVariance(int[] list, float average) {
        double variance = 0;
        for(int i=0; i < list.length; i++) {
            double range = Math.pow(list[i] - average, 2f);
            variance += range;
        }
        return variance/(list.length*1f -1);
    }
}