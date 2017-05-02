package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] data = outputStream.toString().split(" ");
        int result=0;
        if (data[1].equals("+")){
           result =Integer.parseInt(data[0])+ Integer.parseInt(data[2]);
        }else if(data[1].equals("-")){
            result =Integer.parseInt(data[0])- Integer.parseInt(data[2]);
        }else if(data[1].equals("*")){
            result =Integer.parseInt(data[0])* Integer.parseInt(data[2]);
        }
        System.out.printf("%s %s %s = %d",data[0],data[1],data[2],result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

