package com.javarush.task.task19.task1904_Data_ScannerReadFile;

/*
И еще один адаптер
*/

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;
        }
        private Scanner fileScanner;

        @Override
        public Person read() throws IOException {

            String data = "";
            Person person=null;
            if (fileScanner.hasNextLine()) {
                data = fileScanner.nextLine();
                 String[] value = data.split(" ");
                 GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(value[5]), Integer.parseInt(value[4]) - 1, Integer.parseInt(value[3]));
                 person = new Person(value[1], value[2], value[0], calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
