package com.javarush.task.task18.task1801_file_byte;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<Integer> intF = new ArrayList<>();
        String name = reader.readLine();
        FileInputStream list = new FileInputStream(name);
        int value=0;
        while (list.available() > 0){
            intF.add(list.read());
        }
        list.close();
        System.out.println(sort(intF));
    }
    public static int sort(List<Integer> intF){
        int max=0;
        for (int i=0;i<intF.size();i++){
            if (max<intF.get(i)){max=intF.get(i);}
        }
        return max;
    }
}
