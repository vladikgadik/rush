package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        if (args.length>0){
            if (args[0].equals("-c")) {
                crud(args,name);
            }
        }
    }
    public static void crud(String[] args,String name) throws IOException {
        String str="";
        BufferedReader fileInputStream = new BufferedReader(new FileReader(name));
        if(fileInputStream.ready()){
           str=fileInputStream.readLine();
        }
        fileInputStream.close();
        int maxInd=0;
        if (str.length()>10) {
            byte[] file = str.getBytes();
            for (int i = 0; i < file.length / 80; i++) {
                StringBuilder value = new StringBuilder();
                for (int j = 0; j < 8; j++) {
                    value.append((char) file[j + (80 * i)]);
                }
                if (maxInd < Integer.parseInt(value.toString())) {
                    maxInd = Integer.parseInt(value.toString());
                }
            }
        }
        String ind = String.valueOf(maxInd+1);
        if (ind.length()<8){
            for (int i = ind.length();i<8;i++){
            ind = ind+" ";
            }
        }
        StringBuilder result = new  StringBuilder(str);
        result.append(ind).append(args[1]).append(args[2]).append(args[3]);
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        fileOutputStream.write(result.toString().getBytes());
        fileOutputStream.close();
    }
}
