import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    private static ImageIcon backGround = new ImageIcon("D:\\lzc3\\图片2\\start.png");



    public Start(){JFrame f = new JFrame("Ready to go!");
        f.setBounds(570,180,800,460);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        JButton multiMode=new JButton(backGround);
        multiMode.setBounds(-10,-23,800,460);
        multiMode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StartFrame();
            }
        });
        f.add(multiMode);

        f.setVisible(true);


    }
}
