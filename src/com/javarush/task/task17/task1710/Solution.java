package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
        //start here - начни тут
        String[] arr ;
        Sort sort = new Sort();
            arr = args;
            sort.sort(arr);
    }
    public static class Sort{
        public void sort (String[]arr){
          if (arr.length < 1) return;
          if (arr[0].equals("-c") && arr.length > 3) create(arr);
          if (arr[0].equals("-u") && arr.length > 4) update(arr);
          if (arr[0].equals("-d") && arr.length > 1) del(arr);
          if (arr[0].equals("-i") && arr.length > 1) info(arr);
         }

      public void create(String[] arr) {
              if (arr[2].equals("м"))
                  allPeople.add(Person.createMale(arr[1], dateCreate(arr[3])));
              else if (arr[2].equals("ж"))
                  allPeople.add(Person.createFemale(arr[1], dateCreate(arr[3])));
              else return;
          System.out.println(allPeople.size()-1);
      }

      public void update(String[] arr) {
          if (Integer.parseInt(arr[1])>=allPeople.size()) return;
              if (arr[3].equals("м"))
                  allPeople.set(Integer.parseInt(arr[1]), Person.createMale(arr[2], dateCreate(arr[4])));
              else if (arr[3].equals("ж"))
                  allPeople.set(Integer.parseInt(arr[1]), Person.createFemale(arr[2], dateCreate(arr[4])));
              else return;
      }
      public Date dateCreate(String dataStr) {
          Calendar calendar = Calendar.getInstance();
          int[] d = new int[3] ;
          String data[] = dataStr.split("/");
              for (int i = 0; i < data.length; i++) {
                  d[i] = Integer.parseInt(data[i]);
              }
              d[1]=d[1]-1;
              calendar.set(d[2], d[1], d[0]);
          return calendar.getTime();
      }

      public void del(String[] arr) {
          if (Integer.parseInt(arr[1])>=allPeople.size()) return;
          Person per = allPeople.get(Integer.parseInt(arr[1]));
          per.setName(null);
          per.setSex(null);
          per.setBirthDay(null);
      }

      public void info(String[] arr) {
          if (Integer.parseInt(arr[1])>=allPeople.size()) return;
         Person per = allPeople.get(Integer.parseInt(arr[1]));
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

          System.out.println(per.getName()+" "+(per.getSex()==Sex.FEMALE?"ж":"м")+" "+ dateFormat.format(per.getBirthDay()));
      }
    }
}
