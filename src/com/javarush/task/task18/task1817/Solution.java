package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int space =0;
        int other=0;
        int value=0;
        while (fileInputStream.available() > 0){
            value = fileInputStream.read();
            if (value== 32){
                space++;
                other++;
            }else{
               other++;
            }
        }
        fileInputStream.close();
        System.out.printf("%.2f",(space/(float)other)*100);
    }
}
