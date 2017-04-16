package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(true){
            str = reader.readLine();
            if (str.equals("exit")){
                break;
            }
            new ReadThread(str).start();
        }
        for (Map.Entry<String,Integer> pair : resultMap.entrySet()){
            System.out.println(pair.getKey()+"  "+pair.getValue());
        }
    }

    public static class ReadThread   extends Thread {
        public ReadThread(String fileName)  throws FileNotFoundException{
            //implement constructor body
            this.fileName=fileName;
            f = new FileInputStream(fileName);
        }
        String fileName;
        FileInputStream  f;
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            Map<Integer, Integer> map= new HashMap<>();;
            int max=0;
                try {
                    while (f.available() > 0) {
                        int value = f.read();
                        if (map.containsKey(value)) {
                            int a;
                            int counter = map.get(value) + 1;
                            map.put(value, counter);
                            if (counter > max) max = counter;
                        } else {
                            map.put(value, 1);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        f.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            for (Map.Entry<Integer,Integer> pair : map.entrySet()){
                if (pair.getValue().equals(max)){
                    resultMap.put(fileName,pair.getKey());
                }
            }
        }
    }
}
