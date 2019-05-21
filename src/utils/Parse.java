package utils;

public class Parse {
    PaymentEmploye paymentEmploye;
    private String[] dataOfEmploye;
    private String nameOfEmploye="";
    private String tempScheduleOfEmploye;
    private String[] scheduleOfEmploye;
    private int totalValue=0;
    
    public String getNameOfEmploye(String dataFromFile){
         dataOfEmploye = dataFromFile.split("=");
         nameOfEmploye = dataOfEmploye[0];
         return nameOfEmploye;
    }
    
    public int getPaymentenDependeScheduleOfEmploye(String dataFromFile) {
        paymentEmploye = new PaymentEmploye();
        tempScheduleOfEmploye = dataOfEmploye[1];
        scheduleOfEmploye = tempScheduleOfEmploye.split(",");
        totalValue = paymentEmploye.calculatedTotalPaymentHoursOfEmploye(scheduleOfEmploye);
        return totalValue;
    }
    
    public String showPaidOfEachEmploy(String dataFromFile){
        return "The amount to paid: "+getNameOfEmploye(dataFromFile)+" is: "+getPaymentenDependeScheduleOfEmploye(dataFromFile) +" USD";
    }
}
