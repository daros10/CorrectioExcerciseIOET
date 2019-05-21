package utils;

public class PaymentEmploye {
    
    int range1,range2,range3,range4,range5,range6,transformHourIn,transformHourOut;
    int workHours,totalDaysOfWeek,totalWeekend,totalPaymentToEmploye,moneyDaysOfWeek,moneyWeekend;
    private static final String[] DAYS_OF_WEEK = {"MO","TU","WE","TH","FR","SA","SU"};
    private static final int[] MONEY = {15,20,25,30};
    String days="",hourIn="",hourOut="";
    Boolean dayOfWeek,weekend;
    
    public int calculatedTotalPaymentHoursOfEmploye(String[] scheduleOfEmployes) {
        int sizeOfArray = scheduleOfEmployes.length;
        for (int i = 0; i <= (sizeOfArray - 1); i++) {
            days = scheduleOfEmployes[i].substring(0, 2);
            hourIn = scheduleOfEmployes[i].substring(2, 4);
            hourOut = scheduleOfEmployes[i].substring(8, 10);
            isDayOfWeek(days);
            isWeekend(days);
            moneyDaysOfWeek = asignValueOfMoneyDependesHourDaysOfWeek(hourIn, hourOut);
            moneyWeekend = asignValueOfMoneyDependesHourWeekend(hourIn, hourOut);
        }
        totalPaymentToEmploye = moneyDaysOfWeek + moneyWeekend;
        return totalPaymentToEmploye;
    }
    
    public boolean isDayOfWeek(String days){
        if (days.equals(DAYS_OF_WEEK[0]) || days.equals(DAYS_OF_WEEK[1]) || days.equals(DAYS_OF_WEEK[2]) || days.equals(DAYS_OF_WEEK[3]) || days.equals(DAYS_OF_WEEK[4]) ) {
            dayOfWeek = true;
            return dayOfWeek;
        }
        return false;
    }
    
    public boolean isWeekend(String days){
        if (days.equals(DAYS_OF_WEEK[5]) || days.equals(DAYS_OF_WEEK[6]) ) {
            weekend = true;
            return weekend;
        }
        return false;
    }
    
    public int asignValueOfMoneyDependesHourDaysOfWeek(String hourIn, String hourOut) {
        if (isDayOfWeek(days)) {
            transformHourIn = Integer.parseInt(hourIn);
            transformHourOut = Integer.parseInt(hourOut);
            if (transformHourIn >= 00 && transformHourOut <= 9) {
                workHours = (transformHourOut - transformHourIn);
                range1 += workHours * MONEY[2];// 25;
            } else if (transformHourIn >= 9 && transformHourOut <= 18) {
                workHours = (transformHourOut - transformHourIn);
                range2 += workHours * MONEY[0];//15;
            } else if (transformHourIn >= 18 && transformHourOut <= 24) {
                workHours = (transformHourOut - transformHourIn);
                range3 += workHours * MONEY[1];//20;
            }
        }
        totalDaysOfWeek = range1 + range2 + range3;
        return totalDaysOfWeek;
    }
    
    public int asignValueOfMoneyDependesHourWeekend(String hourIn, String hourOut) {
        if (isWeekend(days)) {
            transformHourIn = Integer.parseInt(hourIn);
            transformHourOut = Integer.parseInt(hourOut);
            if (transformHourIn >= 00 && transformHourOut <= 9) {
                workHours = (transformHourOut - transformHourIn);
                range4 += workHours * MONEY[3];// 30;
            } else if (transformHourIn >= 9 && transformHourOut <= 18) {
                workHours = (transformHourOut - transformHourIn);
                range5 += workHours * MONEY[1];//20;
            } else if (transformHourIn >= 18 && transformHourOut <= 24) {
                workHours = (transformHourOut - transformHourIn);
                range6 += workHours * MONEY[2];//25;
            }
        }
        totalWeekend = range4 + range5 + range6;
        return totalWeekend;
    }
}
