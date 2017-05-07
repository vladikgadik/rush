package com.javarush.task.task19.task1919_Map_sort_Value;

/* 
Считаем зарплаты

Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution  {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        Map<String,Double> map = new TreeMap<>();

        while (fileRead.ready()){
            String s= fileRead.readLine();
            if (map.containsKey(s.split(" ")[0])){
               map.put(s.split(" ")[0],map.get(s.split(" ")[0])+Double.parseDouble(s.split(" ")[1])) ;
            }else{
                map.put(s.split(" ")[0],Double.parseDouble(s.split(" ")[1]));
            }
        }
        fileRead.close();

        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString().replaceAll("="," "));
        }

    }
}
