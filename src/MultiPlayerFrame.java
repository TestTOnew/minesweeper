import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiPlayerFrame extends JFrame {
//    static private JLabel gameMode;
    private static ImageIcon backGround = new ImageIcon("D:\\lzc3\\图片2\\j1.jpg");
    private static ImageIcon easy1 = new ImageIcon("D:\\lzc3\\图片2\\easy.png");
    private static ImageIcon mid1 = new ImageIcon("D:\\lzc3\\图片2\\mid.png");
    private static ImageIcon hard1 = new ImageIcon("D:\\lzc3\\图片2\\hard.png");
    private static ImageIcon backButton = new ImageIcon("D:\\lzc3\\图片2\\back.png");
    private static ImageIcon self1 = new ImageIcon("D:\\lzc3\\图片2\\self.png");
    static private JLabel back;


    public MultiPlayerFrame(){
        JFrame f = new JFrame("Ready to go!");
        f.setBounds(570,180,800,460);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        back=new JLabel(backGround);
        back.setBounds(0,0,800,460);
        back.setVisible(true);
        f.add(back);

//        gameMode=new JLabel("Difficulty Choosing");
//        gameMode.setBounds(109,20,200,20);
//        back.add(gameMode);
        JButton easy=new JButton(easy1);
        JButton medium=new JButton(mid1);
        JButton hard=new JButton(hard1);
        JButton diy=new JButton(self1);

        easy.setBounds(60,150,150,150);
        medium.setBounds(230,150,150,150);
        hard.setBounds(400,150,150,150);
        diy.setBounds(570,150,150,150);

        //返回菜单重新选择模式
        JButton back1 = new JButton(backButton);
        back1.setBounds(30, 18,110,50);
        back1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StartFrame();
            }
        });
        back.add(back1);


        easy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();MineClearance.setBomb(10);
                MineClearance.setx(249);
                MineClearance.sety(200);
                MineClearance.setWidth(180);
                MineClearance.setHeight(180);
                MineClearance.setRow(9);
                MineClearance.setCol(9);
                new MineClearance();
                new MineClearance();
                new Times();

            }
        });

        medium.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();MineClearance.setBomb(40);
                MineClearance.setx(180);
                MineClearance.sety(150);
                MineClearance.setWidth(320);
                MineClearance.setHeight(320);
                MineClearance.setRow(16);
                MineClearance.setCol(16);
                new MineClearance();
                new Times();

            }
        });

        hard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                MineClearance.setBomb(99);
                MineClearance.setx(40);
                MineClearance.sety(100);
                MineClearance.setWidth(600);
                MineClearance.setHeight(320);
                MineClearance.setRow(16);
                MineClearance.setCol(30);
                new MineClearance();
                new Times();

            }
        });

        diy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DIY();
            }
        });

//





        back.add(easy); back.add(medium); back.add(hard); back.add(diy);





        f.setVisible(true);






    }

}
