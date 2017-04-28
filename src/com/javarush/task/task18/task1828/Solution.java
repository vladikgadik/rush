package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fisreader = new BufferedReader(new FileReader(fileName));
        List<String> listLine  = new ArrayList<>();
        while (fisreader.ready()) {
            listLine.add(String.format("%s%n", fisreader.readLine()));
        }
        fisreader.close();
        int ind=0;
        boolean isOk = false;
        for (String s:listLine)  {
            if (s.substring(0,8).trim().equals(args[1].trim())) {
                ind =listLine.indexOf(s);
                isOk=true;
            }
        }
        if (args[0].equals("-u")) {
            if(isOk)
            listLine.set(ind, String.format("%-8d%-30s%-8s%-4s%n",Integer.parseInt(args[1]), args[2], args[3], args[4]));
        }
        if (args[0].equals("-d")){
            if (isOk)
            listLine.remove(ind);
        }
        BufferedWriter foswriter = new BufferedWriter(new FileWriter(fileName));
        for (String s : listLine) {
            foswriter.write(s);
        }
        foswriter.close();
    }
}
