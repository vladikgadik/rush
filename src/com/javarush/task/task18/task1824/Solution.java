package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f=null;
        String str="";
        try {
        while(true){
             str = reader.readLine();
             f = new FileInputStream(str);
             f.close();
        }
        }catch (FileNotFoundException e){
            System.out.println(str);
        }
    }
}
