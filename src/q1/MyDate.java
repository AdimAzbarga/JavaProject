
/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q1;
import java.time.LocalDate;
import java.util.Objects;


public class MyDate {
    private int day ;
    private int month;
    private int year;


    public MyDate(int day, int month, int year) {
        LocalDate Today = LocalDate.now();
        if (day >= 1 && day <= 31 )
            this.day = day;
        else
            this.day = Today.getDayOfMonth();
        if (month >= 1 && month <=12 )
            this.month = month;
        else
            this.month = Today.getMonthValue();

        if (year >= 1999 && year <=2100)
            this.year = year;
        else
            this.year = Today.getYear();


    }

    public MyDate(){
      LocalDate Today = LocalDate.now();
      this.day = Today.getDayOfMonth();
      this.month = Today.getMonthValue();
      this.year = Today.getYear();
    }



    public MyDate(MyDate other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }


    public String toString() {
        return day + "/" + month + "/"  +  year ;

    }


    public void printDate(){
        System.out.println(day + "/" + month + "/"  +  year);
    }


    public void printMonthName(){

        String[] months = {"Jan", "Feb", "Mar","Apr","May","june","july","Aug","Sep","Oct","Nov","Dec"};
            System.out.println(day + " "+ months[month-1] + " " + year);


    }


    public int getMonthDay(){
        int days = 0;
        if (month == 1 || month == 3 ||month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
            days = 31;
        if (isLeapYear())
            days = 29;
        if (isLeapYear() && month == 2)
            days = 28;
        if (month == 4 || month ==6 || month == 9 || month == 11)
            days = 30;
        return days ;
    }



    public boolean isLeapYear (){
       return year % 100 != 0 && year % 4 == 0 || (year % 400 == 0);

    }




    public MyDate nextDate(){
        MyDate date = new MyDate(day, month , year);
        if (month == 1 || month == 3 ||month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) {
            if (day != 31)
                date.day = day + 1;
            if (day == 31 && month == 12) {
                date.year = year + 1;
                date.month = 1;
                date.day = 1;
            }
            if (day == 31 && month != 12) {
                date.month = month +1;
                date.day = 1;
            }
        }
        if (month == 4 || month ==6 || month == 9 || month == 11) {
            if (day !=30 ){
                date.day = day +1;
                date.month =month;
            }


            else {
                date.month = month +1;
                date.day = 1;
            }
        }

        if (month == 2  ){
            if (isLeapYear())
                if (day != 29) {
                    date.day = day + 1;
                    date.month = month;

                }
            else{
                date.month = month +1;
                date.day = 1;
                date.year = year;
            }
            else
                if (day != 28){
                    date.day = day +1;
                    date.month =month;
                }
                else
                {
                    date.month = month +1;
                    date.day = 1;
                    date.year = year;
                }
        }

        return date;
    }



    public void printFormatDate(String format){
        if (format.equals("ddmmyy") )
            System.out.println(month + "/" + day + "/"  +  year%100);

        if (format.equals("ddmmyyyy") )
            System.out.println(toString());

        if (format.equals("mmddyyyy") )
            System.out.println(month + "/" + day + "/"  +  year);

        if (format.equals("yyyymmdd") )
            System.out.println(year + "/" + month + "/"  +  day);

        if (format.equals("ddMMyyyy"))
            printMonthName();
    }



    public int compareDate(MyDate object) {
        if (this.day == object.day && this.month == object.month && this.year == object.year)
            return 0;
        if(this.year < object.year)
            return -1;
        if(this.year == object.year){
            if (this.month < object.month)
                return -1;
            if(this.month == object.month)
                if(this.day < object.day)
                return -1;
        }
        return 1;
    }


    public boolean equals(MyDate date) {
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
