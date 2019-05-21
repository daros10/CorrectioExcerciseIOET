package test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utils.Parse;
import utils.PaymentEmploye;
/**
 *
 * @author Daro
 */
@RunWith(value = Parameterized.class)
public class PaymentEmployeTest {
    
   PaymentEmploye paymentEmploye;
   Parse parse;
   private String dataFromFile,actualPaid, expectedPaid;
   
    public PaymentEmployeTest(String dataFromFile, String actualPaid, String expectedPaid){
        this.dataFromFile = dataFromFile;
        this.actualPaid = actualPaid;
        this.expectedPaid = expectedPaid;
    }
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> setOfDataEmployes = new ArrayList<>();
        setOfDataEmployes.add(new Object[]{"RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00","The amount to paid: RENE is: 215 USD","The amount to paid: RENE is: 215 USD"});
        setOfDataEmployes.add(new Object[]{"ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00","The amount to paid: ASTRID is: 85 USD","The amount to paid: ASTRID is: 85 USD"});
        setOfDataEmployes.add(new Object[]{"PEPE=MO09:00-10:00,SU20:00-21:00","The amount to paid: PEPE is: 40 USD","The amount to paid: PEPE is: 40 USD"});
        setOfDataEmployes.add(new Object[]{"ROSA=MO10:00-15:00,TH12:00-14:00,SU15:00-19:00","The amount to paid: ROSA is: 105 USD","The amount to paid: ROSA is: 105 USD"});
        setOfDataEmployes.add(new Object[]{"SARA=MO10:00-12:00,TU10:00-12:00,SA14:00-19:00,SU17:00-21:0000-21:00","The amount to paid: SARA is: 60 USD","The amount to paid: SARA is: 60 USD"});
        setOfDataEmployes.add(new Object[]{"DARIO=MO00:05-02:00,WE19:00-20:00,FR10:00-12:00,SA04:00-06:00,SU10:00-11:00","The amount to paid: DARIO is: 180 USD","The amount to paid: DARIO is: 180 USD"});
        return setOfDataEmployes;
    }
   
    @Before
    public void instanceClassBeforeRunTest() {
        paymentEmploye = new PaymentEmploye();
        parse = new Parse();
    }
    
    @Test
    public void isDayOfWeek(){
        String[] days = {"MO","TU","WE","TH","FR"};
       for (String day : days) {
           assertTrue(paymentEmploye.isDayOfWeek(day));
       }
    }
    
    @Test
    public void isWeekend(){
        String[] days = {"SA", "SU"};
        for(String day : days){
            assertTrue(paymentEmploye.isWeekend(day));
        }
    }
    
    @Test
    public void verifyPaidOfEachEmploye(){
        actualPaid = parse.showPaidOfEachEmploy(dataFromFile);
        assertEquals(expectedPaid, actualPaid);
    }
}
