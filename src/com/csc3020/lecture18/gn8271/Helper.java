package csc3020.lecture18.gn8271;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// *
// Author: Raisa Zaman
// Student ID: gn8271
// Lecture18
// *
public class Helper {
    static FileReader openReader(String filePath) throws FileNotFoundException {
        return  new FileReader(filePath);
    }
    static FileWriter openWriter(String filePath) throws IOException {
        return new FileWriter(filePath);
    }
}
