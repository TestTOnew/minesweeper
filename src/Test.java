import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            DIY mainFrame = new DIY();//创建窗口？？

            // mainFrame.setVisible(true);
        });

    }

    static class DIY extends JFrame {

        static private JLabel row, col, bombNum;
        static private JTextField row1, col1, bombNum1;

        public DIY() {
            JFrame f = new JFrame("PlayerDefined");

            f.setBounds(600, 200, 400, 300);
            f.setLayout(null);
            f.setVisible(true);

            row = new JLabel("Row's grid");
            row.setBounds(20, 20, 60, 20);
            f.add(row);
            row.setVisible(true);

            col = new JLabel("Col's grid");
            col.setBounds(20, 70, 60, 20);
            f.add(col);
            col.setVisible(true);

            bombNum = new JLabel("Number of bomb");
            bombNum.setBounds(20, 120, 100, 20);
            f.add(bombNum);
            bombNum.setVisible(true);

            row1 = new JTextField();
            row1.setBounds(120, 20, 50, 20);
            f.add(row1);
            f.setVisible(true);

            col1 = new JTextField();
            col1.setBounds(120, 70, 50, 20);
            f.add(col1);
            f.setVisible(true);

            bombNum1 = new JTextField();
            bombNum1.setBounds(120, 120, 50, 20);
            f.add(bombNum1);
            f.setVisible(true);


            JButton bt = new JButton("Test");
            bt.setBounds(250, 15,70,30);

            f.add(bt);

            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String row=row1.getText();
                    String col=col1.getText();
                    String bombNum=bombNum1.getText();

                    try {


                        int r = Integer.parseInt(row);
                        int c = Integer.parseInt(col);

                        System.out.println(r);
                        System.out.println(col);
                        System.out.println(bombNum);

                    }

                    catch (Exception y)
                    {
                        System.out.println("invalid");
                    }
                }
            });
        }











    }
}
