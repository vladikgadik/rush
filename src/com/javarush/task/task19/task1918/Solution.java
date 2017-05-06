package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        BufferedReader fileRide = new BufferedReader(new FileReader(nameFile));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = fileRide.readLine())!=null) {
            builder.append(line);
        }
        fileRide.close();
        String str = builder.toString();
        String teg =args[0];
        List<String> list = new ArrayList<>();
        Map<Integer,Boolean> map = new TreeMap<>();

       Pattern patternStart = Pattern.compile("<"+teg+"[\\s>]");
        Pattern patternStop = Pattern.compile("</"+teg+">");
        Matcher matcherStart = patternStart.matcher(str);
        Matcher matcherStop = patternStop.matcher(str);

        while (matcherStart.find()){
            map.put(matcherStart.start(),true);
        }
        
        while (matcherStop.find()){
            map.put(matcherStop.start()+teg.length()+2,false);
        }

        for (Map.Entry<Integer, Boolean> result : map.entrySet()) {
            System.out.println(result.getKey()+"  "+result.getValue());
        }


        while (!map.isEmpty()) {
            int counterStop = 0;
            int indexStart = 0;
            for (Map.Entry<Integer, Boolean> result : map.entrySet()) {
                if (result.getValue()) {
                    if (counterStop == 0) {
                        indexStart = result.getKey();
                    }
                    counterStop++;
                } else {
                    counterStop--;
                }
                //начало строки с закр.тэга,удаление
                if (counterStop < 0){
                    map.remove(result.getKey());
                    break;
                }
                //найден закр.тэг,запись строки и удаление откр. и закр. тэгов
                    if (counterStop == 0) {
                    list.add(str.substring(indexStart, result.getKey()+1));
                    map.remove(indexStart);
                    map.remove(result.getKey());
                    break;
                }
            }
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}