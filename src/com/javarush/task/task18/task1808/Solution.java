package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        String three = reader.readLine();
        FileInputStream inputStream = new FileInputStream(first);
        int size2 = inputStream.available()/2 ;
        int size1 = inputStream.available()-size2;
        byte[] buffer1 = new byte[size1];
        byte[] buffer2 = new byte[size2];
        inputStream.read(buffer1);
        inputStream.read(buffer2);
        FileOutputStream outputStream1 = new FileOutputStream(second);
        FileOutputStream outputStream2 = new FileOutputStream(three);
        outputStream1.write(buffer1);
        outputStream2.write(buffer2);
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
