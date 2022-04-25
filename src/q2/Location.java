/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q2;

import java.util.Arrays;
import java.util.stream.*;

public class Location {
    private String name;
    private Temperature temp[];


    public Location(String name) {
        this.name = name;
    }

    public Location(){}

    public void printLocation(){
        if (temp == null){
            System.out.println("no temperature measurements available!");
        }
        else {
            System.out.print(name + " temperature measurements :" );
            for (Temperature  temp :  this.temp){
                System.out.print(  temp.toString() + " | ");
            }
            System.out.println("");
        }

    }
    public void printLocation(double d ){
        System.out.print(name + " temperature measurements :" );
        for(Temperature temps : this.temp){
            if (temps.getScale() >= getAverage() - d && temps.getScale() <= getAverage() + d ){
                System.out.print( temps.toString() + " | ");
            }
        }
        System.out.println("");
    }

    public int getAverage(){
        if (temp == null){
            return 0;
        }
        int sum =0;
        for(Temperature temps : this.temp){
            sum +=temps.getScale();
        }
        return sum / temp.length;
    }


    public void addTemp(int scale , int day , int month , int year){
        if(temp == null){
            temp = new Temperature[1];
            temp[0] = new Temperature(scale, day ,month , year);
        }
        else
        {
            Temperature tempp[] = this.temp;
            temp = new Temperature[temp.length + 1];
            for(int i =0 ; i< tempp.length ; i++){
                temp[i] = tempp[i];
            }
            temp[temp.length-1] = new Temperature(scale , day, month , year);
        }

    }

    public void addTemp(int scale){
        if(temp == null){
            temp = new Temperature[1];
            temp[0] = new Temperature(scale);
        }
        else
        {
            Temperature tempp[] = this.temp;
            temp = new Temperature[temp.length + 1];
            for(int i =0 ; i< tempp.length ; i++){
                temp[i] = tempp[i];
            }
            temp[temp.length-1] = new Temperature(scale);
        }

    }

    public Temperature getMax(){
        if (temp == null){
            return null;
        }
        Temperature max = new Temperature(0);
        for(Temperature t : this.temp){
            if(t.getScale() > max.getScale() ){
                max = t;
            }
        }
        return max;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Temperature[] getTemp() {
        return temp;
    }

    public void setTemp(Temperature[] temp) {
        this.temp = temp;
    }
}
