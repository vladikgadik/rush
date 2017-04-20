package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fisreader = new BufferedReader(new FileReader(fileName));
        List<String> listLine  = new ArrayList<>();
        while (fisreader.ready()) {
            listLine.add(String.format("%s%n", fisreader.readLine()));
        }
        fisreader.close();
        if (args[0].equals("-c")) {
            int last = Integer.parseInt(listLine.get(listLine.size()-1).substring(0, 8).trim());
            if (last < 99999999)
                last++;
            listLine.add(String.format("%-8d%-30s%-8s%-4s", last, args[1], args[2], args[3]));
            BufferedWriter foswriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : listLine) {
                foswriter.write(s);
            }
            foswriter.close();
        }
    }
}
