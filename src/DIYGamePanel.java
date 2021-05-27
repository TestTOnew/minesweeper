import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DIYGamePanel extends JPanel {
    private int rows, cols, bombCount,flagNum;
    private final int BLOCKWIDTH = 20;
    private final int BLOCKHEIGHT = 20;
    private JLabel[][] label;
    private boolean[][] state;
    private Btn[][] btns;
    private byte[][] click;

    private static ImageIcon flag = new ImageIcon("D:\\lzc3\\图片2\\c.jpg");
    private static ImageIcon bomb = new ImageIcon("D:\\lzc3\\图片2\\a.jpg");
    private static ImageIcon lucency = new ImageIcon("D:\\lzc3\\图片2\\d.png");
    private static ImageIcon wrongFlag= new ImageIcon("D:\\lzc3\\图片2\\g.png");

    private static int sumClickTime;

    static Player SB1;
    static Player PS1;



    //构造雷区,这是构造方法
    public DIYGamePanel(int row, int col, Player SB1, Player PS1 ) {
        sumClickTime=0;
        rows = row;// 行数
        cols = col;// 列数
        DIYGamePanel.SB1 =SB1;
        DIYGamePanel.PS1=PS1;
        //bombCount = rows * cols / 10; // 地雷数
        bombCount = DIY.getGetBombNum(); // 自定义的地雷数
        flagNum = bombCount;// 标记数（用于插旗）
        label = new JLabel[rows][cols];
        state = new boolean[rows][cols];// 用于存储是否有地雷,true就是有，false就是没有
        btns = new Btn[rows][cols];
        click = new byte[rows][cols];// 用于存储按钮点击状态（0-未点击，1-已点击，2-未点击但周围有雷，3-插旗）
        DIYMineClearance.setMineNum(flagNum);
        setLayout(null);
        initLable();

        randomBomb();
        writeNumber();
        randomBtn();



//        SB1=new JLabel(String.format("%d",SB.getScore()));
//        PS1=new JLabel(String.format("%d",PS.getScore()));
//        SB1.setBounds(100,433,10,20);
//        PS1.setBounds(100,462,10,20);


    }

    public void initLable() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel m = new JLabel("", JLabel.CENTER);
                // 设置每个小方格的边界
                m.setBounds(j * BLOCKWIDTH, i * BLOCKHEIGHT, BLOCKWIDTH, BLOCKHEIGHT);

                // 绘制方格边框
                m.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                // 设置方格为透明,便于我们填充颜色
                m.setOpaque(true);

                // 背景填充为蓝色
                m.setBackground(new Color(34, 184, 243, 233));

                // 将方格加入到容器中(即面板JPanel)
                this.add(m);

                // 将方格存到类变量中,方便公用
                label[i][j] = m;
                label[i][j].setVisible(false);
            }
        }
    }

    // 绘制地雷，这个地方不是很懂
    private void randomBomb() {

        for (int i = 0; i < bombCount; i++) {
            int rRow = (int) (Math.random() * rows);
            int rCol = (int) (Math.random() * cols);
            label[rRow][rCol].setIcon(bomb);
            state[rRow][rCol] = true;// 有地雷的格子state为true
        }

    }

    // 绘制数字
    private void writeNumber() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (state[i][j]==true) { continue; }
                int bombCount = 0;

                // 寻找以自己为中心的九个格子中的地雷数
                for (int r = -1; (r + i < rows) && (r < 2); ++r) {
                    if (r + i < 0) continue;
                    for (int c = -1; (c + j < cols) && (c < 2); ++c) {
                        if (c + j < 0) continue;
                        if (state[r + i][c + j]) ++bombCount;
                    }
                }


                if (bombCount > 0) {
                    click[i][j] = 2;//未点击但周围有雷
                    label[i][j].setText(String.valueOf(bombCount));
                }
                if(bombCount==0){label[i][j].setText("0");}//若周围地雷数为0，按钮翻开后数字为0；
            }
        }
    }



    // 绘制按钮
    private void randomBtn() {


        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Btn btn = new Btn();
                btn.i = i;
                btn.j = j;
                btn.setBounds(j * BLOCKWIDTH, i * BLOCKHEIGHT, BLOCKWIDTH, BLOCKHEIGHT);
                this.add(btn);
                btns[i][j] = btn;








//                    btn.addMouseListener(new MouseAdapter() {
//                    public void mouseClicked(MouseEvent e) {
//                        if(e.getButton() == MouseEvent.BUTTON1) open(btn); // 左键点击，打开此按钮方法在下面
//                        if(e.getButton() == MouseEvent.BUTTON3) placeFlag(btn);// 右键点击，插旗方法在下面
//                    }
//                });



                btn.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {

                        if(e.getButton() == MouseEvent.BUTTON1){ // 左键点击，打开此按钮方法在下面

                            open(btn);//先是弹出对话框，”他们被炸伤“，再是计分板更新
                            DIYMineClearance.updateTheNumbers();
                            DIYMineClearance.updatePointer(sumClickTime);

                        }


                        if(e.getButton() == MouseEvent.BUTTON3){
                            placeFlag(btn);
                            DIYMineClearance.updateTheNumbers();
                            DIYMineClearance.updateMistake();
                            DIYMineClearance.updatePointer(sumClickTime);


                        }




                        // 右键点击，插旗方法在下面
//                            if(sumClickTime1%2==1){
//                                PS1.costScore();
//
//                                MineClearance.updateTheNumbers();
//                            }
//
//                            if(sumClickTime1%2==0){
//                                SB1.costScore();
//
//                                MineClearance.updateTheNumbers();
//                            }



                    }
                });


            }
        }





    }

    // 打开这个雷区
    private void open(Btn b){
        sumClickTime++;

        // 踩雷
        if(state[b.i][b.j]){
//            for (int r = 0;r < rows;++r){
//                for(int c = 0;c < cols; ++c){
//                    btns[r][c].setVisible(false);//隐藏label
//                    label[r][c].setVisible(true);// 显示按钮（这里只有隐藏了按钮才能显示按钮下面的label）
//                }
//            }
            btns[b.i][b.j].setVisible(false);//隐藏label
            label[b.i][b.j].setVisible(true);// 显示按钮（这里只有隐藏了按钮才能显示按钮下面的label）


//            if(sumClickTime%2==1){SB1.costScore(); }
//            if(sumClickTime%2==0){PS1.costScore();}

            if(sumClickTime==1){

                JOptionPane.showMessageDialog(null, "只能重来了呀", "重新开始", JOptionPane.PLAIN_MESSAGE);
                btns[b.i][b.j].setVisible(true);
                label[b.i][b.j].setVisible(false);
                sumClickTime=0;
            }else {


//                if (sumClickTime % 2 == 1) {
//                    SB1.costScore();
//                }
//                if (sumClickTime % 2 == 0) {
//                    PS1.costScore();
//                }
                if ((sumClickTime)%(2*DIYMineClearance.getN())>=DIYMineClearance.getN()+1||(sumClickTime)%(2*DIYMineClearance.getN())==0) {
                    PS1.costScore();
                }
                if ((sumClickTime)%(2*DIYMineClearance.getN())<DIYMineClearance.getN()+1&&(sumClickTime)%(2*DIYMineClearance.getN())!=0) {
                    SB1.costScore();
                }

                JOptionPane.showMessageDialog(null,"警告，机器出现损坏","警告",JOptionPane.PLAIN_MESSAGE);
        } }
        else {subOpen(b);}// 没有踩雷
    }


    // 递归打开周边雷区
    private void subOpen(Btn b){
        // 有雷，不能打开
        if(state[b.i][b.j]) return;

        // 打开过的和插旗的，不用打开
        if(click[b.i][b.j] == 1 || click[b.i][b.j] == 4) return;

        // 周围有雷的，只打开它
        if(click[b.i][b.j] == 2) {
            b.setVisible(false);
            label[b.i][b.j].setVisible(true);
            click[b.i][b.j] = 1;
            return;
        }

        // 打开当前这个按钮
        b.setVisible(false);
        label[b.i][b.j].setVisible(true);
        click[b.i][b.j] = 1;

        // 递归检测周边八个按钮
        if(DIY.getGetRow()*DIY.getGetCol()>=100){ for (int r = -1; (r + b.i < rows) && (r < 2); ++r) {
            if (r + b.i < 0) continue;
            for (int c = -1; (c + b.j < cols) && (c < 2); ++c) {
                if (c + b.j < 0) continue;
                if (r==0 && c==0) continue;
                Btn newbtn = btns[r + b.i][c + b.j];
                subOpen(newbtn);
            }
        }}

    }


    // 插旗方法
    private void placeFlag(Btn b){
        sumClickTime++;
        // 只能插和地雷数相同数目的旗子
        if(flagNum>0){
//            // 插过旗的，再点一次取消
//            if(click[b.i][b.j] == 3){
//                if(label[b.i][b.j].getText() == "[0-9]") click[b.i][b.j] = 2;
//                else click[b.i][b.j] = 0;
//                b.setIcon(lucency);
//                ++ flagNum;
//                MineClearance.setMineNum(flagNum);
//            }

            // 未插旗的，插旗
            if(state[b.i][b.j]==true){b.setIcon(flag);}
            else {b.setIcon(wrongFlag);}

//            click[b.i][b.j] = 3;
//            -- flagNum;

            if(state[b.i][b.j]==true) {
                click[b.i][b.j] = 3;
                -- flagNum;}//意思是标记失误，旗子的个数不减。

            DIYMineClearance.setMineNum(flagNum);

//            if(state[b.i][b.j]==true){
//                if(sumClickTime%2==1){SB1.addScore();DIYMineClearance.updatePointer(sumClickTime);}
//                if(sumClickTime%2==0){PS1.addScore();DIYMineClearance.updatePointer(sumClickTime);}
//            }
//            else {
//                if(sumClickTime%2==1){SB1.addMistake();DIYMineClearance.updatePointer(sumClickTime);}
//                if(sumClickTime%2==0){PS1.addMistake();DIYMineClearance.updatePointer(sumClickTime);}
//            }
            if(state[b.i][b.j]==true){
                if((sumClickTime)%(2*DIYMineClearance.getN())<DIYMineClearance.getN()+1&&(sumClickTime)%(2*DIYMineClearance.getN())!=0){
                    SB1.addScore();DIYMineClearance.updatePointer(sumClickTime);
                }
                if((sumClickTime)%(2*DIYMineClearance.getN())>=DIYMineClearance.getN()+1||(sumClickTime)%(2*DIYMineClearance.getN())==0){
                    PS1.addScore();DIYMineClearance.updatePointer(sumClickTime);
                }
            }
            else {
                if((sumClickTime)%(2*DIYMineClearance.getN())<DIYMineClearance.getN()+1&&(sumClickTime)%(2*DIYMineClearance.getN())!=0){
                    SB1.addMistake();DIYMineClearance.updatePointer(sumClickTime);
                }
                if((sumClickTime)%(2*DIYMineClearance.getN())>=DIYMineClearance.getN()+1||(sumClickTime)%(2*DIYMineClearance.getN())==0){
                    PS1.addMistake();DIYMineClearance.updatePointer(sumClickTime);
                }
            }





            //所有旗子插完了，检测是否成功
            if(flagNum == 0){
                boolean flagstate = true;
                for(int i = 0;i < rows; ++i){
                    for(int j = 0;j < cols; ++j){
                        if (click[i][j] != 3 && state[i][j]) flagstate = false;
                    }
                }
                if(flagstate) JOptionPane.showMessageDialog(null,"大人，您成功了，好牛啤","宝贝游戏结束了",JOptionPane.PLAIN_MESSAGE);
            }
        }

        else  {// 旗子用完了，不能插
            JOptionPane.showMessageDialog(null,"标记已用尽","错误操作",JOptionPane.PLAIN_MESSAGE);
        }
    }

    // 显示雷区
    public void showBomb(){
        for (int r = 0;r < rows;++r){
            for(int c = 0;c < cols; ++c){
                btns[r][c].setVisible(false);//隐藏label
                label[r][c].setVisible(true);// 显示按钮（这里只有隐藏了按钮才能显示按钮下面的label）
            }
        }
    }
}


