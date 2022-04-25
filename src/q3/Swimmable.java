/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q3;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public abstract class Swimmable extends Thread {
    protected int horSpeed;
    protected int verSpeed;
    protected Color[] Colors = {Color.black, Color.red, Color.blue, Color.green, Color.cyan, Color.orange, Color.yellow, Color.magenta, Color.pink};
    protected String animalName ;



    //constructors
    public Swimmable(int horSpeed, int verSpeed) {
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
    }

    public Swimmable(){
        horSpeed = 0;
        verSpeed = 0;
    }

    public void print(){
        System.out.println( animalName +" "+  getColor() +" " + getSize() +" "+ getEatCount());

    }


    //constructors
    public abstract void printComponents(Graphics g);

    // abstract Functions
    abstract public String getAnimalName();
    abstract public void drawAnimal(Graphics g);
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public Color getColor();



    //getters & setters
    public int getHorSpeed() {
        return horSpeed;
    }

    public void setHorSpeed(int horSpeed) {
        this.horSpeed = horSpeed;
    }

    public int getVerSpeed() {
        return verSpeed;
    }

    public void setVerSpeed(int verSpeed) {
        this.verSpeed = verSpeed;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

}
