package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Sort sort = new Sort();
        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    sort.create(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    sort.update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    sort.del(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    sort.info(args);
                }
                break;
        }
    }
    public static class Sort{

        public void create(String[] arr) {
            for (int i=0,j=arr.length/3;i<j;i++) {
                if (arr[2+(3*i)].equals("м"))
                    allPeople.add(Person.createMale(arr[1+(3*i)], dateCreate(arr[3+(3*i)])));
                else if (arr[2+(3*i)].equals("ж"))
                    allPeople.add(Person.createFemale(arr[1+(3*i)], dateCreate(arr[3+(3*i)])));
                else return;
                System.out.println(allPeople.size() - 1);
            }
        }

        public void update(String[] arr) {
            for (int i=0,j=arr.length/4;i<j;i++) {
                if (Integer.parseInt(arr[1+(4*i)]) >= allPeople.size()) return;
                if (arr[3+(4*i)].equals("м"))
                    allPeople.set(Integer.parseInt(arr[1+(4*i)]), Person.createMale(arr[2+(4*i)], dateCreate(arr[4+(4*i)])));
                else if (arr[3+(4*i)].equals("ж"))
                    allPeople.set(Integer.parseInt(arr[1+(4*i)]), Person.createFemale(arr[2+(4*i)], dateCreate(arr[4+(4*i)])));
                else return;
            }
        }
        public Date dateCreate(String dataStr) {
            int[] d = new int[3] ;
            Calendar calendar = Calendar.getInstance();
            String data[] = dataStr.split("/");
            for (int i = 0; i < data.length; i++) {
                d[i] = Integer.parseInt(data[i]);
            }
            d[1]=d[1]-1;
            calendar.set(d[2], d[1], d[0]);
            return calendar.getTime();
        }

        public void del(String[] arr) {
            for (int i=0,j=arr.length-1;i<j;i++){
                if (Integer.parseInt(arr[1+i]) >= allPeople.size()) return;
                Person per = allPeople.get(Integer.parseInt(arr[1+i]));
                per.setName(null);
                per.setSex(null);
                per.setBirthDay(null);
            }
        }

        public void info(String[] arr) {
            for (int i=0,j=arr.length-1;i<j;i++) {
                if (Integer.parseInt(arr[1+i]) >= allPeople.size()) return;
                Person per = allPeople.get(Integer.parseInt(arr[1+i]));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(per.getName() + " " + (per.getSex() == Sex.FEMALE ? "ж" : "м") + " " + dateFormat.format(per.getBirthDay()));
            }
        }
    }
}
