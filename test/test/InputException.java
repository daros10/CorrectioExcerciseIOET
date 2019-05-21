package test;
import data.File;
import exception.MyException;
import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import utils.Parse;
/**
 *
 * @author Daro
 */
public class InputException {
    File file;
    
    @Before
    public void instanceClassBeforeRunTest(){
        file = new File();
    }
    
    /*This test verify that set of data is write correctly -- the test fail when the input its ok */
    @Test(expected = MyException.class)
    public void badFormatOfSetOfDataEmploye() throws MyException{
        file.getDataFromFile();
    }
    
    /*the test fail when the file its ok*/
    @Test(expected = MyException.class)
    public void fileNotFound() throws MyException{
        file.getDataFromFile();
        
    }
  
}
