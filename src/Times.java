import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Times {
    private int n;
    static private JLabel number;
    private static ImageIcon backGround = new ImageIcon("D:\\lzc3\\图片2\\number.png");
    private static ImageIcon ok1 = new ImageIcon("D:\\lzc3\\图片2\\ok.png");

    public Times(){
        JFrame f=new JFrame();

        f.setBounds(800,400,300,280);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        number = new JLabel(backGround);
        number.setBounds(-10,-22,300,280);
        f.add(number);



        JLabel label=new JLabel();

        JLabel tips=new JLabel();
        tips.setText("请输入轮替次数（1~5），默认为1");
        tips.setBounds(40,30,200,20);
        number.add(tips);tips.setVisible(true);

        JTextField time = new JTextField();
        time.setBounds(80,70,100,20);
        number.add(time);
        f.setVisible(true);

        JButton ok=new JButton(ok1);
        ok.setBounds(80,145,110,50);
        ok.setVisible(true);
        number.add(ok);



        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t=time.getText();
                n=Integer.parseInt(t);

                f.dispose();

                MineClearance.setn(n);

            }
        });
    }

}

