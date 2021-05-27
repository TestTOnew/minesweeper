import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DIY extends JFrame {

    static private JLabel row,col,bombNum,diy;
    static private JTextField row1, col1, bombNum1;
    private static ImageIcon backGround = new ImageIcon("D:\\lzc3\\图片2\\choosing.png");
    private static ImageIcon ok1 = new ImageIcon("D:\\lzc3\\图片2\\ok.png");
    static int getRow,getCol,getBombNum;


    public DIY(){
        JFrame f = new JFrame("PlayerDefined");

        f.setBounds(600,200,400,300);
        f.setLayout(null);
        f.setVisible(true);

        diy=new JLabel(backGround);
        diy.setBounds(-10,-22,400,300);
        f.add(diy);

        row= new JLabel("Row's grid");
        row.setBounds(20,55,60,20);
        diy.add(row);
        row.setVisible(true);

        col= new JLabel("Col's grid");
        col.setBounds(20,105,60,20);
        diy.add(col);
        col.setVisible(true);

        bombNum=new JLabel("Number of bomb");
        bombNum.setBounds(20,155,100,20);
        diy.add(bombNum);
        bombNum.setVisible(true);

        row1=new JTextField();
        row1.setBounds(120,55,50,20);
        diy.add(row1);
        f.setVisible(true);

        col1=new JTextField();
        col1.setBounds(120,105,50,20);
        diy.add(col1);
        f.setVisible(true);

        bombNum1=new JTextField();
        bombNum1.setBounds(120,155,50,20);
        diy.add(bombNum1);
        f.setVisible(true);

        JButton start = new JButton(ok1);
        start.setBounds(250, 100,110,50);

        diy.add(start);

//        start.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String row=row1.getText();
//                String col=col1.getText();
//                String bombNum=bombNum1.getText();
//
//                getRow = Integer.parseInt(row);
//                getCol = Integer.parseInt(col);
//                getBombNum = Integer.parseInt(bombNum);
//
//                f.dispose();
//                MineClearance.setRow(getRow);
//                MineClearance.setCol(getCol);
//                MineClearance.setBomb(getBombNum);
//                MineClearance.setx(1000-getRow/2);
//                MineClearance.sety(800-getCol/2);
//                MineClearance.setHeight(getRow*20);
//                MineClearance.setWidth(getCol*20);
//                new MineClearance();
//
////                    System.out.println(getRow);
////                    System.out.println(getCol);
////                    System.out.println(getBombNum);
//
//            }
//
//
//        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String row=row1.getText();
                String col=col1.getText();
                String bombNum=bombNum1.getText();

                getRow = Integer.parseInt(row);
                getCol = Integer.parseInt(col);
                getBombNum = Integer.parseInt(bombNum);

                f.dispose();
                new DIYMineClearance();
                new TimesForDIY();

//                    System.out.println(getRow);
//                    System.out.println(getCol);
//                    System.out.println(getBombNum);

            }


        });

    }

    static  public int getGetRow() {
        return getRow;
    }

    static public int getGetCol() {
        return getCol;
    }

    static public int getGetBombNum() {
        return getBombNum;
    }

}
