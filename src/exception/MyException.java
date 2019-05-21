package exception;

public class MyException extends Exception {
    
    private String errorCode;
    public final String FILE_NOT_COMPLY_WITH_THE_FORMAT = "ONE OR SOME ELEMENTS OF THE FILE DO NOT COMPLY WITH THE FORMAT";
    public final String FILE_NOT_FOUND = "THE FILE YOU ARE TRYING TO USE WAS NOT FOUND";
    public final String OTHER_EXPECION = "";
    public final String BAD_FORMAT_ERROR_CODE = "BAD_FORMAT";
    public final String FILE_NOT_FOUND_ERROR_CODE = "FILE_NOT_FOUND";
    public final String OTHER_EXCEPTION_ERROR_CODE = "OTHER_EXCEPTION";
    
    public MyException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }
    /**
     *
     * @return
     */
    @Override
    public String getMessage(){
        String message="";
        switch(errorCode){
            case BAD_FORMAT_ERROR_CODE:
                message = FILE_NOT_COMPLY_WITH_THE_FORMAT; 
                break;
            case FILE_NOT_FOUND_ERROR_CODE:
                message = FILE_NOT_FOUND;
                break;
            case OTHER_EXCEPTION_ERROR_CODE:
                message = OTHER_EXPECION;
                break;
        }
        return message;
    }
}
