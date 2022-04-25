/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q3;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.CyclicBarrier;

public class Jellyfish extends Swimmable{
    private static int DISTANCE_EAT = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front, y_front, x_dir, y_dir;


    public Jellyfish(int size, int x_front, int y_front, int horSpeed, int verSpeed , int col) {
        super(horSpeed, verSpeed);
        this.size = size;
        this.col = col;
        this.x_front = x_front;
        this.y_front = y_front;
        this.x_dir = 1;
        this.y_dir = 1;
        if (eatCount == DISTANCE_EAT) {
            this.size = 1;
        }this.eatCount = 0;
        super.animalName= "Jellyfish";

    }
    public void changeJellyfish(int size){
        this.size += size;
    }

    @Override
    public void printComponents(Graphics g) {

    }

    @Override
    public String getAnimalName() {
        return animalName;
    }

    @Override
    public void drawAnimal(Graphics g) {
        int numLegs;
        if(size<40)
            numLegs = 5;

        else if(size<80)
            numLegs = 9;
        else
            numLegs = 12;
        g.setColor(Colors[col]);
        g.fillArc(x_front - size/2, y_front - size/4, size, size/2, 0, 180);
        for(int i=0; i<numLegs; i++)
            g.drawLine(x_front - size/2 + size/numLegs + size*i/(numLegs+1),
                    y_front, x_front - size/2 + size/numLegs + size*i/(numLegs+1),
                    y_front+size/3);
    }

    @Override
    public void setSuspend() {

    }

    @Override
    public void setResume() {

    }

    @Override
    public void setBarrier(CyclicBarrier b) {

    }

    @Override
    public int getEatCount() {
        return eatCount;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Color getColor() {
        return Colors[col - 1];
    }

    @Override
    public void eatInc() {
        eatCount ++;
        if(eatCount == DISTANCE_EAT){
            eatCount = 0;
            this.size++;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jellyfish jellyfish = (Jellyfish) o;
        return size == jellyfish.size && col == jellyfish.col && eatCount == jellyfish.eatCount && x_front == jellyfish.x_front && y_front == jellyfish.y_front && x_dir == jellyfish.x_dir && y_dir == jellyfish.y_dir && animalName.equals(jellyfish.animalName);
    }

    public static int getDistanceEat() {
        return DISTANCE_EAT;
    }

    public static void setDistanceEat(int distanceEat) {
        DISTANCE_EAT = distanceEat;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setEatCount(int eatCount) {
        this.eatCount = eatCount;
    }

    public int getX_front() {
        return x_front;
    }

    public void setX_front(int x_front) {
        this.x_front = x_front;
    }

    public int getY_front() {
        return y_front;
    }

    public void setY_front(int y_front) {
        this.y_front = y_front;
    }

    public int getX_dir() {
        return x_dir;
    }

    public void setX_dir(int x_dir) {
        this.x_dir = x_dir;
    }

    public int getY_dir() {
        return y_dir;
    }

    public void setY_dir(int y_dir) {
        this.y_dir = y_dir;
    }
}
