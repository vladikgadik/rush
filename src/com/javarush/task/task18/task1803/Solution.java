package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Самые частые байты
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int max = 0;
        FileInputStream inputstream = new FileInputStream(name);
        Map<Integer,Integer> map = new HashMap<>();
        while (inputstream.available()>0){
            int value = inputstream.read();
            if (map.containsKey(value)){
                int counter = map.get(value)+1;
                map.put(value,counter);
                if (counter>max)max=counter;
            }else{
                map.put(value,1);
            }
        }
        StringBuffer result=new StringBuffer();
        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            System.out.println("key= "+pair.getKey()+"  value= "+pair.getValue());
            if (pair.getValue().equals(max)){
               result.append(String.valueOf(pair.getKey())).append(" ");
            }
        }
        System.out.println(result);
        inputstream.close();
    }
}
