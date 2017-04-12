package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       FileInputStream inputStream;
            while (true) {
               inputStream=new FileInputStream(reader.readLine());
                if (inputStream.available() < 1000 ) {
                    inputStream.close();
                    reader.close();
                    throw new DownloadException();
                }
                inputStream.close();
            }
    }

    public static class DownloadException extends Exception {
    }
}
