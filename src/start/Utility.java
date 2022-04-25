/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package start;

import org.jetbrains.annotations.NotNull;
import q1.MyDate;
import q2.Location;
import q2.Temperature;
import q3.Swimmable;
import q3.Fish;
import q3.Jellyfish;
import q3.UnusualFish;

import java.util.*;

public class Utility
{
    public static MyDate threeDates(MyDate[] dates){
        for(MyDate date : dates){
            for(MyDate date1 : dates){
                if (date1.equals(date.nextDate())){
                    for(MyDate date2 : dates)
                    {
                        if(date2.equals(date1.nextDate())){
                            return date;
                        }
                    }
                }

            }
        }
       return new MyDate();
    }



    public static int getMaxTemp(Location locations[]){
        double max = 0;
        int index = 0;
        for(Location l : locations){
            if(l.getAverage() > max ){
                max = l.getAverage();
                index = Arrays.asList(locations).indexOf(l);
            }
        }
        return index;
    }


    public static void printAquarium(Swimmable[] swimmables){
        System.out.println("Aquarium[type/color/actual size/eat count]");
        for(Swimmable swimmable : swimmables){
            swimmable.print();
        }
        System.out.println("");

    }

    public static void feedAquaticAnimal(Swimmable[] swimmables, int eatcount){
        Random rand = new Random();
        for(int i =0 ;i < eatcount ;i++){
            int index = rand.nextInt(swimmables.length);
            swimmables[index].eatInc();
        }
        System.out.println("");
    }


    public static int countAquaticAnimal(Swimmable[] swimmables) {
        int count = 0 ;
        int small = swimmables[0].getSize();
        for(Swimmable swimmable : swimmables){
            if(swimmable.getSize() < small )
                count++;
        }
        return count;
    }

    public static void sortAquaticAnimal(Swimmable[] swimmables){
        int count = 0;
        Swimmable[] swimmables2 = swimmables;
        Swimmable s;
       for(int i=0;i< swimmables.length;i++){
           for(Swimmable swimmable2: swimmables){
              if(swimmables[i].getSize() > swimmable2.getSize())
                count ++;
           }
           s = swimmables2[count];
           swimmables2[count] = swimmables[i];
           swimmables2[i] = s;
           count = 0;

       }
       swimmables = swimmables2;

    }

}
