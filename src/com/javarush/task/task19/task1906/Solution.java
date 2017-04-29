package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(firstName);
        List<Integer> list = new ArrayList<>();
        int value=0;
        while ((value=fileReader.read())!=-1){
           list.add(value);
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(secondName);
        for (int i=0;i<list.size();i++){
            if ((i+1)%2==0){
                fileWriter.write(list.get(i));
                System.out.println(i);
            }
        }
        fileWriter.close();
    }
}
