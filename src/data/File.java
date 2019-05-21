package data;
import exception.MyException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Parse;

public class File {
    
    private static final String FILE_NAME = "datosFail.txt";
    //private static final String 
    private String temporalReadFile = "";
    private String dataReaderFromFile = "";
    private final String BAD_FORMAT = "BAD_FORMAT";
    private final String FILE_NOT_FOUND = "FILE_NOT_FOUND";
    Parse parse = new Parse();
    Pattern pattern = Pattern.compile("[a-zA-Z]+\\=+[MO|TU|WE|TH|FR|SU|SA]+\\d{2}\\:\\d{2}\\-\\d{2}\\:\\d{2}\\,+[MO|TU|WE|TH|FR|SU|SA]+\\d{2}\\:\\d{2}\\-\\d{2}\\:\\d{2}");
    Matcher matcher;
    
    public void getDataFromFile() throws MyException {
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((temporalReadFile = bufferedReader.readLine()) != null) {
                dataReaderFromFile = temporalReadFile;
                verifyFormatOfInputDataSet();
            }
            bufferedReader.close();
        } catch (IOException exception) {
            throw new MyException(FILE_NOT_FOUND);
        }
    }

    public boolean isCoincidence(String dataOfFile){
        boolean flag;
        matcher = pattern.matcher(dataOfFile);
        flag = matcher.find();
        return flag;
    }
    
    public void verifyFormatOfInputDataSet() throws MyException {
        if (isCoincidence(temporalReadFile)) {
            System.out.println(parse.showPaidOfEachEmploy(dataReaderFromFile));
        } else {
            throw new MyException(BAD_FORMAT);
        }
    }
}
