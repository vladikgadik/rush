package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(name1));
        FileOutputStream file2 = new FileOutputStream(name2);
        String str ="";
        if (file1.ready()){
          str=file1.readLine();
        }
        String[] s = str.split(" ");
        int[] value=new int[s.length];
        StringBuilder sum = new StringBuilder();
        for (int i = 0;i<s.length;i++){
        sum.append((int)Math.round(Double.parseDouble(s[i])));
            sum.append(" ");
        }
        file2.write(sum.toString().getBytes());
        file1.close();
        file2.close();
    }
}
