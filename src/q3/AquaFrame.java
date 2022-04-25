package q3;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class AquaFrame extends JFrame implements ActionListener{

    public static AquaFrame frame = new AquaFrame("my Aquarium");
    private JSlider sl_size, sl_x , sl_y ,sl_num;
    private JRadioButton button1, button2;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JDialog help;
    private String[] Colors = {"black", "red", "blue", "green", "cyan", "orange"," yellow", "magenta", "pink"};
    private JComboBox<String> cmb;
    private Color clr;
    private Image backgroundImage;
    JPanel panel;
    private JDialog d;


    public static ArrayList<Swimmable> fish = new ArrayList<>();
    public AquaFrame(String str){
        super(str);
    }
    public static void main(String[] args) {
        frame.setLayout(new BorderLayout());
        String[] buttons = {"Add Animal","Sleep","Wake up","Reset","Food","info","Exit"};
        frame.setSize(1000,670);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);




        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Background");
        JMenu m3 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("Exit");
        JMenuItem m21= new JMenuItem("Image");
        JMenuItem m22 = new JMenuItem("Blue");
        JMenuItem m23= new JMenuItem("None");
        JMenuItem m31 = new JMenuItem("Help");
        m1.add(m11);
        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m3.add(m31);
        m11.addActionListener(frame);
        m21.addActionListener(frame);
        m22.addActionListener(frame);
        m23.addActionListener(frame);
        m31.addActionListener(frame);


        //creating buttons
        JPanel panel = new JPanel();
        JButton[] button = new JButton[buttons.length];
        panel.setLayout(new GridLayout(1,7,0,0));
        for(int i=0;i<buttons.length;i++) {
            button[i]=new JButton(buttons[i]);
            button[i].setBackground(Color.lightGray);
            button[i].addActionListener(frame);
            panel.add(button[i]);
        }
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }

    public void AddAnimalDialog(){

        d = new JDialog(this,"Add animal");



        l1 = new JLabel("Set a new life",JLabel.CENTER);
        d.add(l1);
        d.setLayout(new GridLayout(6,1,10,5));
        sl_num = new JSlider(1,5);
        sl_num.setMajorTickSpacing(1);
        sl_num.setMinorTickSpacing(1);
        sl_num.setPaintTicks(true);
        sl_num.setPaintLabels(true);
        d.add(sl_num);
        l1 = new JLabel("",JLabel.CENTER);
        d.add(l1);



        l2 = new JLabel("size of jelly fish",JLabel.CENTER);
        d.add(l2);
        d.setLayout(new GridLayout(6,1,10,5));
        sl_size = new JSlider(20,320);
        sl_size.setMajorTickSpacing(50);
        sl_size.setMinorTickSpacing(50);
        sl_size.setPaintTicks(true);
        sl_size.setPaintLabels(true);
        d.add(sl_size);
        l1 = new JLabel("",JLabel.CENTER);
        d.add(l1);



        l3 = new JLabel("Vertical speed",JLabel.CENTER);
        d.add(l3);
        d.setLayout(new GridLayout(6,1,10,5));
        sl_y = new JSlider(1,10);
        sl_y.setMajorTickSpacing(1);
        sl_y.setMinorTickSpacing(1);
        sl_y.setPaintTicks(true);
        sl_y.setPaintLabels(true);
        d.add(sl_y);
        l1 = new JLabel("",JLabel.CENTER);
        d.add(l1);



        l4 = new JLabel("Horizontal speed",JLabel.CENTER);
        d.add(l4);
        d.setLayout(new GridLayout(6,1,10,5));
        sl_x = new JSlider(1,10);
        sl_x.setMajorTickSpacing(1);
        sl_x.setMinorTickSpacing(1);
        sl_x.setPaintTicks(true);
        sl_x.setPaintLabels(true);
        d.add(sl_x);
        l1 = new JLabel("",JLabel.CENTER);
        d.add(l1);



       button1 = new JRadioButton();
       button2 = new JRadioButton();
        l5 = new JLabel("Type",JLabel.CENTER);
        d.add(l5);
        d.setLayout(new GridLayout(6,1,10,5));
        button1.setText("Fish");
        button1.setBounds(120, 30, 120, 50);
        button2.setText("jelly Fish");
        button2.setBounds(120, 30, 120, 50);
        d.add(button1);
        d.add(button2);



        l6 = new JLabel("Choose color :",JLabel.CENTER);
        d.add(l6);
        cmb = new JComboBox<String>(Colors);
        cmb.setBounds(50, 50,90,20);
        d.add(cmb);



        JPanel panel = new JPanel();
        JButton button1 = new JButton("OK");
        JButton button2 = new JButton("Cancel");
        panel.setLayout(new GridLayout(1,7,0,0));
        button1.setBackground(Color.lightGray);
        button1.addActionListener(this);
        panel.add(button1);
        button2.setBackground(Color.lightGray);
        button2.addActionListener(this);
        panel.add(button2);

        d.getContentPane().add(BorderLayout.SOUTH, panel);




        d.setSize(800, 400);
        // set visibility of dialog
        d.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Add Animal")) {
            AddAnimalDialog();
        }
        if(s.equals("OK")){
            d.setVisible(false);
            initiateAllValues(sl_num.getValue(),sl_size.getValue(),sl_y.getValue(),sl_x.getValue(),button1.isSelected(),button2.isSelected(),cmb.getSelectedIndex());


        }
        if(s.equals("Exit")){
            System.exit(0);
        }

       // if(s.equals("Image")){
           // frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));


       // }

        if(s.equals("Blue")){
            frame.getContentPane().setBackground(new Color(66, 177, 222));
        }

        if(s.equals("None")){
            frame.getContentPane().setBackground(null);
        }

        if(s.equals("Help")){
            HelpDialog();
        }

        if(s.equals("ok")){
            help.setVisible(false);
        }

    }
    public void initiateAllValues(int NumberOfFish, int SizeOfFish, int Xspeed, int Yspeed, boolean IsFish, boolean IsJelly, int color){
        switch (color) {
            case 0:
                clr = new Color(9, 6, 6);
                break;
            case 1:
                clr = new Color(255, 0, 0);
                break;
            case 2:
                clr = new Color(36, 140, 213);
                break;
            case 3:
                clr = new Color(109, 170, 53);
                break;
            case 4:
                clr = new Color(32, 231, 231);
                break;
            case 5:
                clr = new Color(217, 116, 31);
                break;
            case 6:
                clr = new Color(232, 243, 110);
                break;
            case 7:
                clr = new Color(217, 43, 194);
                break;
            case 8:
                clr = new Color(255, 165, 165);
                break;
        }

        panel = new AquaPanel(NumberOfFish,  SizeOfFish,  Xspeed,  Yspeed,  IsFish,  IsJelly,  color);
        add(panel);
        setVisible(true);
        repaint();



    }

    public void HelpDialog(){
        help =new JDialog(this,"Message");
        JPanel panel = new JPanel();
        JLabel help1 = new JLabel("Home Work 3",JLabel.CENTER);
        help.setLayout(new GridLayout(6,1,10,5));
        JLabel help2 = new JLabel("GUI & Threads",JLabel.CENTER);

        JButton btn = new JButton("ok");
        btn.setPreferredSize(new Dimension(50, 20));
        help.add(help1);
        help.add(help2);
        panel.add(btn);
        help.getContentPane().add(BorderLayout.SOUTH, panel);
        btn.addActionListener(this);

        help.setSize(350,215);
        help.setVisible(true);

    }

}



