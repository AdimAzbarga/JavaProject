/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/
package q3;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class Fish extends Swimmable {
    private static int DISTANCE_EAT = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front, y_front, x_dir, y_dir;



    //constructors

    public Fish(int size, int x_front, int y_front, int horSpeed, int verSpeed , int col) {
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
        super.animalName= "Fish";

    }

    public void changeFish(int size){
        this.size += size;
    }

    public void changeColor(){
        if(++col == 9) col =1;
    }

    @Override
    public void printComponents(Graphics g) {
        for(Swimmable s : AquaFrame.fish){
            s.drawAnimal(g);
        }
    }

    @Override
    public String getAnimalName() {
        return animalName;
    }

    @Override
    public void drawAnimal(Graphics g) {
        g.setColor(Colors[col]);
        if(x_dir==1) // fish swims to right side
        {
            // Body of fish
            g.fillOval(x_front - size, y_front - size/4, size, size/2);
            // Tail of fish
            int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);
            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-Colors[col].getRed(),255-Colors[col].getGreen(),255-
                    Colors[col].getBlue()));
            g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);
            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
        else // fish swims to left side
        {
            // Body of fish
            g.fillOval(x_front, y_front - size/4, size, size/2);
            // Tail of fish
            int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);// Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-Colors[col].getRed(),255-Colors[col].getGreen(),255-
                    Colors[col].getBlue()));
            g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);
            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
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



    public static int getDistanceEat() {
        return DISTANCE_EAT;
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

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }


}
