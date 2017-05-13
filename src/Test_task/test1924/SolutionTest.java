package Test_task.test1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTest {

/*
Замена чисел
*/
        public static Map<Integer, String> map = new HashMap<Integer, String>();
        static {
            map.put(1,"один");
            map.put(2,"два");
            map.put(3,"три");
            map.put(4,"четыре");
            map.put(5,"пять");
            map.put(6,"шесть");
            map.put(7,"семь");
            map.put(8,"восемь");
            map.put(9,"девять");
            map.put(10,"десять");
            map.put(11,"одиннадцать");
            map.put(12,"двенадцать");
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String nameFile = "D:/1.txt";
            reader.close();
            BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));
            List<String> listData = new ArrayList<>();
            List<String> listResult = new ArrayList<>();
            while (readerFile.ready()){
                listData.add(readerFile.readLine());
            }
            readerFile.close();

            for (int i=0;i<listData.size();i++){
                String s = listData.get(i);
                for (Map.Entry<Integer, String> pair : map.entrySet()){
                    s = s.replaceAll("(^"+pair.getKey()+"\\s)|(\\s"+pair.getKey()+"\\s)|(\\s"+pair.getKey()+"$)"," "+pair.getValue()+" ");//"\\s+"+pair.getKey()+"\\s+"
                }

                listResult.add(s.trim());
            }

            for (int i=0;i<listData.size();i++){
                System.out.println(listData.get(i));
            }

            for (int i=0;i<listResult.size();i++){
                System.out.println(listResult.get(i));
            }
        }
    }
