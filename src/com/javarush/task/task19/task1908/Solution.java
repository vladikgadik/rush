package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oneName = reader.readLine();
        String twoName = reader.readLine();
        reader.close();
        BufferedReader fileRead = new BufferedReader(new FileReader(oneName));
        StringBuilder str = new StringBuilder();
        while (fileRead.ready()){
            str.append(fileRead.readLine()).append(" ");
        }
        fileRead.close();
        String[] s = str.toString().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0;i<s.length;i++){
            if(s[i].matches("\\d+")){
                stringBuilder.append(s[i]).append(" ");
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(twoName));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
}
