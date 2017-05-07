package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        Map<String,Double> map = new TreeMap<>();

        while (fileRead.ready()){
            String str= fileRead.readLine();
            if (map.containsKey(str.split(" ")[0])){
                map.put(str.split(" ")[0],map.get(str.split(" ")[0])+Double.parseDouble(str.split(" ")[1])) ;
            }else{
                map.put(str.split(" ")[0],Double.parseDouble(str.split(" ")[1]));
            }
        }
        fileRead.close();

        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String,String> mapMax = new TreeMap<>();
        String indexKey  = list.get(list.size()-1).toString().split("=")[0];
        String indexValue= list.get(list.size()-1).toString().split("=")[1];
        mapMax.put(indexKey,indexValue);
        for (int i=list.size()-2;i>=0;i--){
            if (Double.parseDouble(list.get(i).toString().split("=")[1])==Double.parseDouble(list.get(list.size()-1).toString().split("=")[1])){
                mapMax.put(list.get(i).toString().split("=")[0],list.get(i).toString().split("=")[1]);
            }else{
                break;
            }
        }
        for (Map.Entry<String,String> result : mapMax.entrySet()){
            System.out.println(result.getKey());
        }
    }
}
