package q3;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AquaPanel extends JPanel {
    public AquaPanel(int NumberOfFish, int SizeOfFish, int Xspeed, int Yspeed, boolean IsFish, boolean IsJelly, int color) {
        if(IsFish){
            for(int i=0;i<NumberOfFish;i++){
                AquaFrame.fish.add(new Fish(SizeOfFish, -10, -10, Xspeed ,Yspeed, color));
            }
        }
        if(IsJelly){
            for(int i=0;i<NumberOfFish;i++){
                AquaFrame.fish.add(new Jellyfish(SizeOfFish, 80, 80 , Xspeed ,Yspeed, color));
            }
        }
        setPreferredSize(new Dimension(400, 400));
        repaint();
    }


    @Override
    public void printComponents(Graphics g) {
        super.printComponents(g);
        for(Swimmable s : AquaFrame.fish){
            s.drawAnimal(g);
        }
    }



}


