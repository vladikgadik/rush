package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputstream = new FileInputStream(name);
        int result=0;
        while (inputstream.available()>0){
            int value = inputstream.read();
            if (value==44){
                result++;
            }
        }
        System.out.println(result);
        reader.close();
        inputstream.close();
    }
}
