//Trevor McDonough
//Computer Programming 2

import javax.swing.*;
import java.awt.*;


public class FortuneTellerViewer
{

    public static void main(String[] args)
    {
    JFrame frame = new JFrame();

    frame.setTitle("Fortune Teller");
    frame.setFont(Font.getFont("Dialog"));
    frame.setSize(800,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon fortuneTellerIcon = new ImageIcon("C:\\Users\\tmcd6\\Documents\\FortuneTeller\\src\\fortune-teller.png");

    JLabel label = new JLabel("Fortune Teller", fortuneTellerIcon, JLabel.CENTER);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.TOP);
    frame.add(label);
    frame.setVisible(true);


    }



}
