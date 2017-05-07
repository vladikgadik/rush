package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        List<String> listData = new ArrayList<>();
        while (fileRead.ready()){
            listData.add(fileRead.readLine());
        }
        fileRead.close();
        StringBuilder result = new StringBuilder();
        for (int i = 0;i<listData.size();i++){
            String[] lineData = listData.get(i).split("\\s+") ;
                for (int j=0;j<lineData.length;j++){
                    if (lineData[j].matches("^\\S*\\d+\\S*$")){
                        result.append(lineData[j]).append(" ");
                    }
                }
        }
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(args[1]));
        writeFile.write(result.toString());
        writeFile.close();
    }
}
