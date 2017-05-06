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
        int startSub1;
        int startSub2;
        int startSub=0;
        while (true) {
          //  проверка откр.тэга
             startSub1 = str.indexOf("<" + teg + " ",startSub);
             startSub2 = str.indexOf("<" + teg + ">",startSub);
            if (startSub1 == startSub2) {
                startSub = startSub1;
            } else if (startSub1 < startSub2 && startSub1 >= 0) {
                startSub = startSub1;
            } else if (startSub2 >= 0) {
                startSub = startSub2;
            } else {
                startSub = startSub1;
            }
            //если конец тэгов
            if (startSub < 0) {
                break;
            }
            //запись откр.тэгов
            map.put(startSub,true);
            //поиск со следующего символа
            startSub++;
        }
        int end=0;
        while (true) {
            end = str.indexOf("/" + teg + ">", end);
            //если конец тэгов
            if (end < 0) {
                break;
            }
            end = end + teg.length() + 1;
            //запись закр.тэгов
            map.put(end, false);
            //поиск со следующего символа
            end++;
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