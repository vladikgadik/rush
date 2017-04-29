package com.javarush.task.task19.task1904_Data_ScannerReadFile;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
