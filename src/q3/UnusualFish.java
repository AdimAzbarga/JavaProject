/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/

package q3;

public class UnusualFish extends Fish{
    private int factor;


    public UnusualFish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col, int factor) {
        super(size, x_front, y_front, horSpeed, verSpeed, col);
        this.factor = factor;
        super.animalName= "UnusualFish";

    }

    public int getSize(){
        return super.getSize() * this.factor;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
}
