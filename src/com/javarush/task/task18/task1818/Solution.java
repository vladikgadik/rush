package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> name = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<3;i++)name.add(reader.readLine());
        FileOutputStream file1 = new FileOutputStream(name.get(0));
        FileInputStream file2 = new FileInputStream(name.get(1));
        FileInputStream file3 = new FileInputStream(name.get(2));
        if (file2.available()>0){
            byte[] buffer = new byte[file2.available()];
            file2.read(buffer);
            file1.write(buffer);
        }
        if (file3.available()>0){
            byte[] buffer = new byte[file3.available()];
            file3.read(buffer);
            file1.write(buffer);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
