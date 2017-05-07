package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));
        List<String> listData = new ArrayList<>();
        List<String> listResult = new ArrayList<>();
        while (readerFile.ready()){
            listData.add(readerFile.readLine());
        }
        readerFile.close();

        for (int i=0;i<listData.size();i++){
          String str = " "+listData.get(i)+" ";
            for (Map.Entry<Integer, String> pair : map.entrySet()){
                str = str.replaceAll("\\s+"+pair.getKey()+"\\s+"," "+pair.getValue()+" ");
            }
            listResult.add(str.trim());
        }

        for (int i=0;i<listData.size();i++){
           System.out.println(listResult.get(i));
        }
    }
}
