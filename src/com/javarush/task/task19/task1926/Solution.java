package com.javarush.task.task19.task1926;

/* 
Перевертыши
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
        String nameFile = reader.readLine();
        reader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));
        List<String> listData = new ArrayList<>();
        while (readerFile.ready()){
            listData.add(readerFile.readLine());
        }
        readerFile.close();
        for (int i=0;i<listData.size();i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(listData.get(i)).reverse();
            System.out.println(stringBuilder.toString());
        }
    }
}
