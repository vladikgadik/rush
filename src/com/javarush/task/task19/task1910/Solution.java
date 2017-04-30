package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            str.append(fileRead.readLine()).append("\n");
        }
        fileRead.close();
        String result = str.toString().replaceAll("\\W","");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(twoName));
        bufferedWriter.write(result.toString());
        bufferedWriter.close();
    }
}
