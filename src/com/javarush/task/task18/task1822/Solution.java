package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(name1));
        String str ="";
        while ((str = file1.readLine()) != null){
            if (str.startsWith(args[0]+" ")){
                System.out.println(str);
                break;
            }
        }
        file1.close();
    }
}
