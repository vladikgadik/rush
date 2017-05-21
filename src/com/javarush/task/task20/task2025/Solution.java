package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static Long[] getNumbers(long N) {
        Long[] result = null;
        List<Long> listResult = new LinkedList<>();
        List<Byte> listPars = new ArrayList<>();
        long value=0;
        long valueMulti=0;
        long valueResult=0;
        for (long i=1;i<=N;i++){
            value=i;
            while (value>0){
                listPars.add((byte)(value%10));
                value=value/10;
            }
            for (int n=0, k = listPars.size();n<k;n++) {
                valueMulti = listPars.get(n);
                for (int j = 1; j < k; j++) {
                    valueMulti = valueMulti * listPars.get(n);
                }
                valueResult = valueResult + valueMulti;
            }
            if (i==valueResult){
                listResult.add(i);
            }
            valueResult=0;
            listPars.clear();
        }
        if (!listResult.isEmpty()) {
            result = listResult.toArray(new Long[listResult.size()]);
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        Long[] result = getNumbers(214746720);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}