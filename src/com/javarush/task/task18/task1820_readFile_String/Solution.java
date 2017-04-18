package com.javarush.task.task18.task1820_readFile_String;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s =12345+"";
        byte[] b = s.getBytes();
        StringBuilder builder = new StringBuilder();

        for (int i = 0;i<b.length;i++){
            builder.append((char) b[i]);
        }
        System.out.println(builder.toString());
      metod2();
    }
    // obrabotka vseh strok
    public static void metod2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);
        byte[]b=new byte[file1.available()];
        if (file1.available()>0){
           file1.read(b);
        }
        String[] s = new String(b).split(" ");
        StringBuilder sum = new StringBuilder();
        for (int i = 0;i<s.length;i++){
            sum.append((int)Math.round(Double.parseDouble(s[i])));
            sum.append(" ");
        }
        file2.write(sum.toString().getBytes());
        file1.close();
        file2.close();
    }
// obrabotka do konca stroki
    public static void metod1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(name1));
        FileOutputStream file2 = new FileOutputStream(name2);
        String str ="";
        if (file1.ready()){
            str=file1.readLine();
        }
        String[] s = str.split(" ");
        StringBuilder sum = new StringBuilder();
        for (int i = 0;i<s.length;i++){
            sum.append((int)Math.round(Double.parseDouble(s[i])));
            sum.append(" ");
        }
        file2.write(sum.toString().getBytes());
        file1.close();
        file2.close();
    }
}
