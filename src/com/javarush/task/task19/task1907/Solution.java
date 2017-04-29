package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFale = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(nameFale);
        List<Integer> list = new ArrayList<>();
        while (fileReader.ready()){
            list.add(fileReader.read());
        }
        fileReader.close();
        StringBuilder s = new StringBuilder();
        for (int i=0;i<list.size();i++){
            s.append( (char)(int)list.get(i));
        }
        String[] test = s.toString().replaceAll("\\W"," ").split("\\s+");
        int result= 0;
        for (int i=0;i<test.length;i++){
           if (test[i].equals("world")){
               result++;
           }
        }
        System.out.println(result);
    }
}
