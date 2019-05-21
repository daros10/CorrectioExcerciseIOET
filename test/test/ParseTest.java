package test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import utils.Parse;
/**
 *
 * @author Daro
 */
@RunWith(value = Parameterized.class)
public class ParseTest {

    private final String dataFromFile;
    private  String actualName;
    private final String expectedName;
    Parse parse;
    
    public ParseTest(String dataFromFile, String actualName, String expectedName){
        this.dataFromFile = dataFromFile;
        this.actualName = actualName;
        this.expectedName = expectedName;
    }
    
    @Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> setOfDataEmployes = new ArrayList<>();
        setOfDataEmployes.add(new Object[]{"RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00","RENE","RENE"});
        setOfDataEmployes.add(new Object[]{"ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00","ASTRID","ASTRID"});
        setOfDataEmployes.add(new Object[]{"PEPE=MO09:00-10:00,SU20:00-21:00","PEPE","PEPE"});
        setOfDataEmployes.add(new Object[]{"ROSA=MO10:00-15:00,TH12:00-14:00,SU15:00-19:00","ROSA","ROSA"});
        setOfDataEmployes.add(new Object[]{"SARA=MO10:00-12:00,TU10:00-12:00,SA14:00-19:00,SU17:00-21:0000-21:00","SARA","SARA"});
        setOfDataEmployes.add(new Object[]{"DARIO=MO00:05-02:00,WE19:00-20:00,FR10:00-12:00,SA04:00-06:00,SU10:00-11:00","DARIO","DARIO"});
        return setOfDataEmployes;
    }
   
    @Before
    public void instanceClassBeforeRunTest(){
        parse = new Parse();
    }
    
    /*This test allow that you verified if you get the name of employe of the data set*/
    @Test
    public void nameOfEmploye(){
        actualName = parse.getNameOfEmploye(dataFromFile);
        assertEquals(expectedName, actualName);
    }
    
}
