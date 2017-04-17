package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream;
        List<byte[]> listB = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String str = null;
        boolean isEnd =false;
        while(!isEnd){
            str = reader.readLine();
            if (str.equals("end")){
                isEnd=true;
            }else {
                list.add(str);
            }
        }

        String value;
        int value1=0;
        int value2=0;
        for (int i =1;i<list.size();i++){
            for (int j=0;j<list.size()-1;j++){
                value = list.get(j);
                value1= list.get(j).indexOf(".part");
                value1= Integer.parseInt(list.get(j).substring(value1+5));
                value2= list.get(j+1).indexOf(".part");
                value2= Integer.parseInt(list.get(j+1).substring(value2+5));
                if (value1>value2){
                    list.set(j,list.get(j+1));
                    list.set(j+1,value);
                }
            }
        }
        for (int i=0;i<list.size();i++){
            fileInputStream = new FileInputStream(list.get(i));
            if (fileInputStream.available()>0){
                byte[] b=new byte[fileInputStream.available()];
                fileInputStream.read(b);
                listB.add(b);
            }
            fileInputStream.close();
        }
        int index =list.get(0).indexOf(".part");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(list.get(0).substring(0,index)));
        for (int i=0;i<listB.size();i++) {
            fileOutputStream.write(listB.get(i));
        }
        fileOutputStream.close();

    }
}
