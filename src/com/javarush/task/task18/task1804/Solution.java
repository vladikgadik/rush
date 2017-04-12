package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int min = Integer.MAX_VALUE;
        FileInputStream inputstream = new FileInputStream(name);
        Map<Integer,Integer> map = new HashMap<>();
        while (inputstream.available()>0){
            int value = inputstream.read();
            if (map.containsKey(value)){
                int counter = map.get(value)+1;
                map.put(value,counter);
            }else{
                map.put(value,1);
            }
        }
        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            if (min>pair.getValue())min=pair.getValue();
        }
        StringBuffer result=new StringBuffer();
        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            System.out.println("key= "+pair.getKey()+"  value= "+pair.getValue());
            if (pair.getValue().equals(min)){
                result.append(String.valueOf(pair.getKey())).append(" ");
            }
        }
        System.out.println(result);
        inputstream.close();
    }
}
