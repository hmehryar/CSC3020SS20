package csc3020.lecture16.hm;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
public class Helper {
    public static FileReader openReader(String filePath) throws FileNotFoundException {
        return  new FileReader(filePath);
    }
}
