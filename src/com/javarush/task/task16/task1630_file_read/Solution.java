package com.javarush.task.task16.task1630_file_read;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
       private String fullFileName = "";
        private String filleCont ="";
        private String line = "";
        public List<String> lines = new ArrayList<String>();
        BufferedReader reader;
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return filleCont;
        }

        public void run(){
            try {
                reader = new BufferedReader(new FileReader(fullFileName));
                while ((line=reader.readLine())!= null){
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            } finally {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            for (int i=0,j=lines.size();i<j;i++){
                filleCont = filleCont +" "+lines.get(i);
            }
        }
    }
}
