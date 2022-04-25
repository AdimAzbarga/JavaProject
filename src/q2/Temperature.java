/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q2;
import q1.MyDate;

public class Temperature extends MyDate {
    private double scale;
    private MyDate scale_date;


    public Temperature(double scale, int day, int month, int year) {
        super(day, month, year);
        this.scale = scale;
        this.scale_date = new MyDate(day ,  month , year);

    }


    public Temperature(Temperature other){
        super(other);
        this.scale = other.scale;
    }

    public Temperature(double scale) {
        this.scale = scale;
        this.scale_date = new MyDate();
    }

    public Temperature(){}




    public String toString() {
        printTemp();
        return  " " +scale_date.getDay() + "/" + scale_date.getMonth() + "/" + scale_date.getYear() ;
    }

    public void printTemp(){
        if (scale > 0)
            System.out.print("+" + scale + "C°" );
        else
            System.out.print("-" + scale + "C°" );
    }


    public void printTempFull(){
        printTemp();
        System.out.print(" " + scale_date.getDay() + "/" + scale_date.getMonth() + "/" + scale_date.getYear());
    }

    public Temperature compareTemp(Temperature object){
        return  (this.scale > object.scale) ? this : object;

    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public MyDate getScale_date() {
        return scale_date;
    }

    public void setScale_date(MyDate scale_date) {
        this.scale_date = scale_date;
    }


}
