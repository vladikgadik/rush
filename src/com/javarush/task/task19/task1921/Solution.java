package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/*
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        List<String> list = new ArrayList<>();
        while (fileRead.ready()){
            String s = fileRead.readLine();
            list.add(s);
        }
        fileRead.close();

        for (int i=0;i<list.size();i++){
            String[] str = list.get(i).split("\\s+");
            StringBuilder name=new StringBuilder();
            for (int j = 0;j<str.length-3;j++){
                name.append(str[j]).append(" ");
            }
            GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(str[str.length-1]), Integer.parseInt(str[str.length-2]) - 1, Integer.parseInt(str[str.length-3]));
            PEOPLE.add(new Person(name.toString().trim(),calendar.getTime()));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        for (int i=0;i<PEOPLE.size();i++){
            System.out.println(PEOPLE.get(i).getName()+" "+dateFormat.format(PEOPLE.get(i).getBirthday())) ;
        }
    }
}
