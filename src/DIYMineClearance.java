
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class
DIYMineClearance extends JFrame {
    static private int mineNum = 0; //可用旗子数
    private static ImageIcon face = new ImageIcon("D:\\lzc3\\图片2\\b.jpg");/* 小黄脸图标 */
    private static ImageIcon field = new ImageIcon("D:\\lzc3\\图片2\\field.png");
    private static ImageIcon backButton = new ImageIcon("D:\\lzc3\\图片2\\back.png");
    private static ImageIcon result = new ImageIcon("D:\\lzc3\\图片2\\result.png");
    static private JLabel difficulty,label2,SpongeBob,PatrickStar,pointer1,pointer2,miss1,miss2,backGround;// 难度，提示文字,玩家一的积分，玩家二的积分
    static private DIYGamePanel diyMineField;    // 雷区

    static  Player SB;
    static  Player PS;



    public DIYMineClearance(){
        // 绘制窗口
        JFrame f = new JFrame("地狱扫荡");

        SB=new Player();
        PS=new Player();


        //f.setBounds(600,200,500,600);
        f.setBounds(600,200,700,700);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);


//        //显示难度的标签
//        difficulty=new JLabel("自定义难度");
//        difficulty.setBounds(50,20,120,20);
//        f.add(difficulty);

        backGround=new JLabel(field);
        backGround.setBounds(-10,0,700,580);
        f.add(backGround);


        // 显示旗子数的标签
        label2 = new JLabel("剩余:"+mineNum);
        label2.setBounds(550,583,120,20);
        f.add(label2);




        //玩家一和二，现在只有标签，肯定还要写player类，弄积分
        SpongeBob=new JLabel("Friday 检测到的地雷"+SB.getScore());
        PatrickStar=new JLabel("Jarvis 检测到的地雷"+PS.getScore());
        SpongeBob.setBounds(25,583,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
        PatrickStar.setBounds(25,612,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
        f.add(SpongeBob);
        f.add(PatrickStar);

        miss1=new JLabel("Friday 失误"+SB.getMistake());
        miss2=new JLabel("Jarvis 失误"+PS.getMistake());
        miss1.setBounds(225,583,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
        miss2.setBounds(225,612,250,20);//多次评估感觉这个位置的视觉感受是最舒服的
        f.add(miss1);miss1.setVisible(true);
        f.add(miss2);miss2.setVisible(true);

        pointer1=new JLabel("@");
        pointer2=new JLabel("@");
        pointer1.setBounds(10,603,100,20);
        pointer2.setBounds(10,632,100,20);
        f.add(pointer1);f.add(pointer2);
        pointer1.setVisible(false);pointer2.setVisible(false);


        // 重置按钮
        JButton bt = new JButton(face);
        bt.setBounds(330, 15,30,30);
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DIYMineClearance();
            }
        });
        backGround.add(bt);

        //作弊看所有地雷
        JButton cheat = new JButton();
        cheat.setBounds(550, 605,35,35);
        cheat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                f.dispose();
                diyMineField.showBomb();
            }
        });
        f.add(cheat);

        JButton backCheat = new JButton();
        backCheat.setBounds(590, 605,35,35);
        backCheat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DIYMineClearance();
            }
        });
        f.add(backCheat);

        //游戏结束，结算界面
        JButton over = new JButton(result);
        over.setBounds(550,40,110,50);
        over.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DIYGameOver();
            }
        });
        backGround.add(over);

        //返回菜单重新选择模式
        JButton back = new JButton(backButton);
        back.setBounds(40, 40,110,50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MultiPlayerFrame();
            }
        });
        backGround.add(back);

        // 绘制扫雷区
        //mineField = new GamePanel(20,20);
        diyMineField = new DIYGamePanel(DIY.getGetRow(),DIY.getGetCol(),SB,PS);
        //mineField.setBounds(40,100,400,400);
        diyMineField.setBounds(40,100,DIY.getGetCol()*20,DIY.getGetRow()*20);
        backGround.add(diyMineField);
        // 显示界面
        f.setVisible(true);

    }
    private static int n;
    public static void setn(int a){
        n=a;
    }
    public static int getN(){
        return n;
    }
    public static void changePlayer(int sum){
        int a=2*n;int b=n-1;

        if (sum%(a)>=b){
            updatePointer(sum);
            updateMistake();
            updateTheNumbers();
        }else {
            updatePointer(sum);
            updateMistake();
            updateTheNumbers();
        }
    }





    // 修改旗子数
    public static void setMineNum(int i){
        mineNum = i;
        label2.setText("剩下的旗子:"+mineNum);
    }

    public static void updatePointer(int sum){
//        if (a%2==1){
//            pointer1.setVisible(false);pointer2.setVisible(true);
//        }else {
//            pointer1.setVisible(true);pointer2.setVisible(false);
//        }
        int a=2*n;int b=n-1;
        if (sum%(a)>b){
            pointer1.setVisible(false);pointer2.setVisible(true);
        }else {
            pointer1.setVisible(true);pointer2.setVisible(false);
        }

    }



    public static void updateMistake(){
        miss1.setText("Friday 失误:"+SB.getMistake());
        miss2.setText("Jarvis 失误:"+PS.getMistake());
    }



    public static void updateTheNumbers(){
        SpongeBob.setText("Friday 检测到的地雷:"+SB.getScore());
        PatrickStar.setText("Jarvis 检测到的地雷:"+PS.getScore());
    }


}

