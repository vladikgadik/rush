package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
       // List<String> listData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (readerFile.ready()){
           String[] s = readerFile.readLine().replaceAll("\n","").split(" ");
            for (int i=0;i<s.length;i++){
                if (s[i].length()>6){
                    stringBuilder.append(s[i]).append(",");
                }
            }
        }
        readerFile.close();

        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(args[1]));
        fileWrite.write(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
        fileWrite.close();
    }
}
