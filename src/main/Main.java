package main;
import data.File;
import exception.MyException;
/**
 *
 * @author Daro
 */
public class Main {
    public static void main(String[] args) throws MyException {
        File file = new File();
        file.getDataFromFile();
    }
}
