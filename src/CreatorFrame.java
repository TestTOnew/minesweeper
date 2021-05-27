import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatorFrame extends JFrame {

    private static ImageIcon backButton = new ImageIcon("D:\\lzc3\\图片2\\back.png");
    private static ImageIcon creator = new ImageIcon("D:\\lzc3\\图片2\\creator.png");
    static private JLabel back;

    public CreatorFrame(){
        JFrame f = new JFrame("幕后制作团队");
        f.setBounds(570,180,800,460);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        f.setVisible(true);


        back=new JLabel(creator);
        back.setBounds(-10,-23,800,460);
        back.setVisible(true);
        f.add(back);

        //返回菜单重新选择模式
        JButton back1 = new JButton(backButton);
        back1.setBounds(40, 40,110,50);
        back1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StartFrame();
            }
        });
        back.add(back1);

    }
}
