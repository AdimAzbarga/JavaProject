/*
    Students : Adim Azbarga 322844424
               Shahd Alnaami 324175090

*/
package q3;

public class MultiColorFish extends Fish{


    public MultiColorFish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col) {
        super(size, x_front, y_front, horSpeed, verSpeed, col);
        super.animalName = "MultiColorFish";
    }
    @Override
    public void changeFish(int size){
        super.setSize(super.getSize()+size);
        super.changeColor();

    }
}
