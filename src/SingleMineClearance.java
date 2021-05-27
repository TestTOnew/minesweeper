import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleMineClearance extends JFrame {
    static private int midtime = 3600;
    static private int mineNum = 99;//可用旗子数
    private static ImageIcon face = new ImageIcon("D:\\lzc3\\图片2\\b.jpg");/* 小黄脸图标 */
    private static ImageIcon field = new ImageIcon("D:\\lzc3\\图片2\\field.png");
    static private JLabel label1,difficulty,label2,backGround,SpongeBob,PatrickStar,pointer1,pointer2,miss1,miss2;// 难度，提示文字,玩家一的积分，玩家二的积分
    static private SingleGamePanel singleMineField;    // 雷区

//    static  Player SB;
//    static  Player PS;



    public SingleMineClearance(){
        // 绘制窗口
        JFrame f = new JFrame("地狱扫荡");

//        SB=new Player();
//        PS=new Player();


        //f.setBounds(600,200,500,600);
        f.setBounds(600,200,700,700);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);

        backGround=new JLabel(field);
        backGround.setBounds(-10,0,700,580);
        f.add(backGround);



//        //显示难度的标签
//        difficulty=new JLabel("魔鬼难度");
//        difficulty.setBounds(50,20,120,20);
//        f.add(difficulty);
        label1 = new JLabel("剩余时间：" +(midtime / 60 / 60 % 60) + ":"+ (midtime / 60 % 60)+ ":" +(midtime % 60));
        label1.setBounds(10,580,120,20);
        f.add(label1);



        // 显示旗子数的标签
        label2 = new JLabel("剩余:"+mineNum);
        label2.setBounds(550,580,120,20);
        f.add(label2);




//        //玩家一和二，现在只有标签，肯定还要写player类，弄积分
//        SpongeBob=new JLabel("海绵宝宝 * 在海底抓住的地雷:"+SB.getScore());
//        PatrickStar=new JLabel("派大星 * 在海底抓住的地雷:"+PS.getScore());
//        SpongeBob.setBounds(25,433,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
//        PatrickStar.setBounds(25,462,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
//        f.add(SpongeBob);
//        f.add(PatrickStar);
//
//        miss1=new JLabel("海绵宝宝 * miss:"+SB.getMistake());
//        miss2=new JLabel("派大星 * miss:"+PS.getMistake());
//        miss1.setBounds(225,433,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
//        miss2.setBounds(225,462,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
//        f.add(miss1);miss1.setVisible(true);
//        f.add(miss2);miss2.setVisible(true);
//
//        pointer1=new JLabel("@");
//        pointer2=new JLabel("@");
//        pointer1.setBounds(10,433,100,20);
//        pointer2.setBounds(10,462,100,20);
//        f.add(pointer1);f.add(pointer2);
//        pointer1.setVisible(false);pointer2.setVisible(false);






        // 重置按钮
        JButton bt = new JButton(face);
        bt.setBounds(325, 15,30,30);
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new SingleMineClearance();
            }
        });
        backGround.add(bt);



        //返回菜单重新选择模式
        JButton back = new JButton("Back");
        back.setBounds(50, 40,80,30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StartFrame();
            }
        });
        backGround.add(back);


        // 绘制扫雷区
        //mineField = new GamePanel(20,20);
        singleMineField = new SingleGamePanel(16,30);
        //mineField.setBounds(40,100,400,400);
        singleMineField.setBounds(40,100,600,320);
        backGround.add(singleMineField);
        // 显示界面
        f.setVisible(true);

    }

    static class CountDown extends Thread{
        public void run(){
            while (midtime > 0){
                try{
                    -- midtime;
                    label1.setText("剩余时间：" +(midtime / 60 / 60 % 60) + ":"+ (midtime / 60 % 60)+ ":" +(midtime % 60));
                    this.sleep(1000);
                }catch (Exception e){
                    System.out.println("错误：" + e.toString());
                }
            }
            if(midtime == 0) {
                singleMineField.showBomb();
                JOptionPane.showMessageDialog(null,"时间已到","游戏结束",JOptionPane.PLAIN_MESSAGE);
            }
        }

    }




    // 修改旗子数
    public static void setMineNum(int i){
        mineNum = i;
        label2.setText("剩下的旗子:"+mineNum);
    }





}


