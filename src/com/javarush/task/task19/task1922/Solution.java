package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        BufferedReader fileRead = new BufferedReader(new FileReader(nameFile));
        List<String> list = new ArrayList<>();
        while (fileRead.ready()){
            String s = fileRead.readLine();
            list.add(s);
        }
        fileRead.close();
        int counter =0;
        for (int i = 0;i<list.size();i++){
                 for (int j = 0;j<words.size();j++){
                     if (list.get(i).indexOf(words.get(j))>=0) {
                         counter++;
                     }
                 }
                 if (counter==2){
                        System.out.println(list.get(i));
                 }
                 counter=0;
        }
    }
}
