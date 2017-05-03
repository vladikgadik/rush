package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String name) throws IOException {
        fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(File file) throws IOException{
        fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(String name, boolean append) throws IOException{
        fileWriter = new FileWriter(name, append);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException{
        fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }


    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off,off+len));
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off,off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void close() throws IOException{
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {

    }

}
