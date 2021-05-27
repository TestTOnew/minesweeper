import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

public class StartFrame extends JFrame {

    private static ImageIcon backGround = new ImageIcon("D:\\lzc3\\图片2\\g.jpg");
    private static ImageIcon mode1 = new ImageIcon("D:\\lzc3\\图片2\\mode1.png");
    private static ImageIcon mode2 = new ImageIcon("D:\\lzc3\\图片2\\mode2.png");
    private static ImageIcon mode3 = new ImageIcon("D:\\lzc3\\图片2\\ai.png");
    private static ImageIcon help1= new ImageIcon("D:\\lzc3\\图片2\\help.png");
    private static ImageIcon team = new ImageIcon("D:\\lzc3\\图片2\\team.png");
    static private JLabel back;


    public StartFrame(){
        JFrame f = new JFrame("Ready to go!");
        f.setBounds(570,180,800,460);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        back=new JLabel(backGround);
        back.setBounds(0,0,800,460);
        back.setVisible(true);
        f.add(back);

        JButton multiMode=new JButton(mode1);
        multiMode.setBounds(50,209,250,120);
        multiMode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MultiPlayerFrame();
            }
        });
        back.add(multiMode);


        JButton singleMode=new JButton(mode2);
        singleMode.setBounds(50,77,250,120);
        singleMode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new SingleMineClearance();
                SingleMineClearance.CountDown time = new SingleMineClearance.CountDown();
                time.start();
            }
        });
        back.add(singleMode);

        JButton AIMode=new JButton(mode3);
        AIMode.setBounds(310,77,250,120);
        AIMode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new AIPlayerFrame();
            }
        });
        back.add(AIMode);




        JButton help=new JButton(help1);
        help.setBounds(440,209,120,120);
        help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new HelpFrame();
            }
        });
        back.add(help);

        JButton creators=new JButton(team);
        creators.setBounds(310,209,120,120);
        creators.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new CreatorFrame();
            }
        });
        back.add(creators);





        f.setVisible(true);

    }



}
