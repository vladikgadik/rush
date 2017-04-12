package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputstream = new FileInputStream(name);
        List<Integer> map = new ArrayList<>();
        while (inputstream.available()>0){
            int value = inputstream.read();
            if (!map.contains(value)){
                map.add(value);
            }
        }
        int min;
        for (int i=1;i<map.size();i++){
            for (int j=0;j<map.size()-i;j++){
                min=map.get(j);
                if (map.get(j)>map.get(j+1)){
                    map.set(j,map.get(j+1));
                    map.set(j+1,min);
                }
            }
        }
        StringBuffer result=new StringBuffer();
        for (int i=0;i<map.size();i++){
            System.out.println(map.get(i));
                result.append(String.valueOf(map.get(i))).append(" ");
        }
        System.out.println(result);
        inputstream.close();
    }
}
