import java.util.Date;

public class DateConverter {
    public static Date fromInt(int year, int month, int day){
        long temp = -1;
        int [] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days_pass = 0;
       
        if (year % 4 == 0) {
            days[1] = 28;
        }

        if (!(
            (year < 1970) ||
            (day < 1) ||
            (day > days[month - 1]) ||
            (month < 1) ||
            (month > 12)
        )){
            for (int index = 0; index < month - 1; index++) {
                days_pass += days[index];
            }

            for (int index = 1970; index < year; index++) {
                if (index % 4 == 0) {
                    days_pass += 366;
                } else {
                    days_pass += 365;
                }
                
            }

            temp = (days_pass + day) * 24 * 3600 * 1000;
            System.out.println("Good");
        }
        return new Date(temp);
    }
}
