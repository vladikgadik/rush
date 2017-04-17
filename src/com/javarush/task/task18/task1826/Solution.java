package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            byte[] b = new byte[fileInputStream.available()];
            fileInputStream.read(b);
            for (int i=0;i<b.length;i++){
                b[i]= (byte) (b[i]- 2);
            }
            fileOutputStream.write(b);
        }else if (args[0].equals("-d")){
            byte[] b = new byte[fileInputStream.available()];
            fileInputStream.read(b);
            for (int i=0;i<b.length;i++){
                if (b[i]>0)
                    b[i]= (byte) (b[i]+ 2);
            }
            fileOutputStream.write(b);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
