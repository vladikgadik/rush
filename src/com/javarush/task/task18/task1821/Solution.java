package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputstream = new FileInputStream(args[0]);
        Map<Integer,Integer> map = new TreeMap<>();
        while (inputstream.available()>0){
            int value = inputstream.read();
          int a;
                if (map.containsKey(value)) {
                    int counter = map.get(value) + 1;
                    map.put(value, counter);
                } else {
                    map.put(value, 1);
                }

        }
        for (Map.Entry <Integer,Integer> pair : map.entrySet()) {
            System.out.println( (char)pair.getKey().intValue()+" "+pair.getValue());
        }
        inputstream.close();
    }
}
