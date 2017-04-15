package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int counter =0;
        int value=0;
        while (fileInputStream.available() > 0){
            value = fileInputStream.read();
            if (value>64 && value < 91 || value >96 && value < 123){
                counter++;
            }
        }
        fileInputStream.close();
        System.out.println(counter);
    }
}
