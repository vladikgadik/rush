package com.javarush.task.task17.task1721_read_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static   String firstFileName;
    public static   String secondFileName;
    public static void main(String[] args) throws IOException {

     BufferedReader list = new BufferedReader(new InputStreamReader(System.in));
        firstFileName=list.readLine();
       secondFileName=list.readLine();
        readFile(firstFileName,allLines);
        readFile(secondFileName,forRemoveLines);
        try {
           new Solution().joinData();
        }catch (CorruptedDataException e){
        }

    }

    public void joinData () throws CorruptedDataException {
        boolean isNot=true;
        for (int i=0;i<forRemoveLines.size();i++){
            for (int j=0;j<allLines.size();j++){
                if (forRemoveLines.get(i).equals(allLines.get(j))){
                    isNot = false;
                }
            }
            if(isNot){
                allLines.clear();
                throw  new CorruptedDataException();
            }
            isNot=true;
        }
        for (int i=0;i<forRemoveLines.size();i++){
            for (int j=0;j<allLines.size();j++){
                if (forRemoveLines.get(i).equals(allLines.get(j))){
                    allLines.remove(j);
                    j--;
                }
            }
        }

    }
    public static void readFile(String nameF,List<String> list)  {
        String line;
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(nameF));
            while ((line=reader.readLine())!= null){
                list.add(line);
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        try {
            reader.close();
        } catch (IOException e1) {
        }
    }
    }
}
