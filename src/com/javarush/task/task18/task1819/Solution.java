package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(name1);
        byte[] buffer=null;
        byte[] buffer1;
        if (file1.available()>0){
            buffer = new byte[file1.available()];
            file1.read(buffer);
        }
        file1.close();
        FileOutputStream file = new FileOutputStream(name1);
        FileInputStream file2 =new FileInputStream(name2);
        if (file2.available()>0){
           buffer1 = new byte[file2.available()];
            file2.read(buffer1);
            file.write(buffer1);
        }
        file.write(buffer);

        file2.close();
        file.close();
    }
}
