import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;

class SingleGamePanel extends JPanel {
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
    /* 构造雷区 */
    public SingleGamePanel(int row, int col) {
        rows = row;/* 行数 */
        cols = col;/* 列数 */
        bombCount = 99; /* 地雷数 */
        flagNum = bombCount;/* 标记数（用于插旗） */
        label = new JLabel[rows][cols];
        state = new boolean[rows][cols];/* 用于存储是否有地雷 */
        btns = new Btn[rows][cols];
        click = new byte[rows][cols];/* 用于存储按钮点击状态（0-未点击，1-已点击，2-未点击但周围有雷，3-插旗） */

        setLayout(null);
        initLable();
        randomBomb();
        writeNumber();
        randomBtn();
    }

    public void initLable() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel l = new JLabel("", JLabel.CENTER);
                // 设置每个小方格的边界
                l.setBounds(j * BLOCKWIDTH, i * BLOCKHEIGHT, BLOCKWIDTH, BLOCKHEIGHT);
                // 绘制方格边框
                l.setBorder(BorderFactory.createLineBorder(GRAY));
                // 设置方格为透明,便于我们填充颜色
                l.setOpaque(true);
                // 背景填充为黄色
                l.setBackground(new Color(255, 184, 243, 233));
                // 将方格加入到容器中(即面板JPanel)
                this.add(l);
                // 将方格存到类变量中,方便公用
                label[i][j] = l;
                label[i][j].setVisible(false);
            }
        }
    }

    /* 绘制地雷 */
    private void randomBomb() {
        for (int i = 0; i < bombCount; i++) {
            int rRow = (int) (Math.random() * rows);
            int rCol = (int) (Math.random() * cols);
            label[rRow][rCol].setIcon(bomb);
            state[rRow][rCol] = true;/* 有地雷的格子state为真 */
        }
    }

    /* 绘制数字 */
    private void writeNumber() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (state[i][j]) {
                    continue;
                }
                int bombCount = 0;
                /* 寻找以自己为中心的九个格子中的地雷数 */
                for (int r = -1; (r + i < rows) && (r < 2); ++r) {
                    if (r + i < 0) continue;
                    for (int c = -1; (c + j < cols) && (c < 2); ++c) {
                        if (c + j < 0) continue;
                        if (state[r + i][c + j]) ++bombCount;
                    }
                }
                if (bombCount > 0) {
                    click[i][j] = 2;
                    label[i][j].setText(String.valueOf(bombCount));
                }
            }
        }
    }
    /* 绘制按钮 */
    private void randomBtn() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Btn btn = new Btn();
                btn.i = i;
                btn.j = j;
                btn.setBounds(j * BLOCKWIDTH, i * BLOCKHEIGHT, BLOCKWIDTH, BLOCKHEIGHT);
                this.add(btn);
                btns[i][j] = btn;
                btn.addMouseListener(new MouseAdapter() {
                                         public void mouseClicked(MouseEvent e) {
                                             /* 左键点击 */
                                             if(e.getButton() == MouseEvent.BUTTON1) open(btn);
                                             /* 右键点击 */
                                             if(e.getButton() == MouseEvent.BUTTON3) placeFlag(btn);
                                         }

                                     }
                );

            }
        }

    }
    /* 打开这个雷区 */
    private void open(Btn b){
        /* 踩雷 */
        if(state[b.i][b.j]){
            for (int r = 0;r < rows;++r){
                for(int c = 0;c < cols; ++c){
                    btns[r][c].setVisible(false);/* 隐藏label */
                    label[r][c].setVisible(true);/* 显示按钮（这里只有隐藏了按钮才能显示按钮下面的label） */
                }
            }
            JOptionPane.showMessageDialog(null,"您失败了","游戏结束",JOptionPane.PLAIN_MESSAGE);
        }else /* 没有踩雷 */{
            subopen(b);
        }
    }
    /* 递归打开周边雷区 */
    private void subopen(Btn b){
        /* 有雷，不能打开 */
        if(state[b.i][b.j]) return;
        /* 打开过的和插旗的，不用打开 */
        if(click[b.i][b.j] == 1 || click[b.i][b.j] == 4) return;
        /* 周围有雷的，只打开它 */
        if(click[b.i][b.j] == 2) {
            b.setVisible(false);
            label[b.i][b.j].setVisible(true);
            click[b.i][b.j] = 1;
            return;
        }
        /* 打开当前这个按钮 */
        b.setVisible(false);
        label[b.i][b.j].setVisible(true);
        click[b.i][b.j] = 1;
        /* 递归检测周边八个按钮 */
        for (int r = -1; (r + b.i < rows) && (r < 2); ++r) {
            if (r + b.i < 0) continue;
            for (int c = -1; (c + b.j < cols) && (c < 2); ++c) {
                if (c + b.j < 0) continue;
                if (r==0 && c==0) continue;
                Btn newbtn = btns[r + b.i][c + b.j];
                subopen(newbtn);
            }
        }
    }
    /* 插旗 */
    private void placeFlag(Btn b){
        /* 只能插和地雷数相同数目的旗子 */
        if(flagNum>0){
            /* 插过旗的，再点一次取消 */
            if(click[b.i][b.j] == 3){
                if(label[b.i][b.j].getText() == "[0-9]") click[b.i][b.j] = 2;
                else click[b.i][b.j] = 0;
                b.setIcon(lucency);
                ++ flagNum;
                SingleMineClearance.setMineNum(flagNum);
            }else /* 未插旗的，插旗 */{
                if(state[b.i][b.j]==true){
                    b.setIcon(flag);
                    click[b.i][b.j] = 3;
                    -- flagNum;
                }
                else {b.setIcon(wrongFlag);}



                SingleMineClearance.setMineNum(flagNum);
            }
            /* 把所有旗子插完了，检测是否成功 */
            if(flagNum == 0){
                boolean flagstate = true;
                for(int i = 0;i < rows; ++i){
                    for(int j = 0;j < cols; ++j){
                        if (click[i][j] != 3 && state[i][j]) flagstate = false;
                    }
                }
                if(flagstate) JOptionPane.showMessageDialog(null,"您成功了","游戏结束",JOptionPane.PLAIN_MESSAGE);
            }
        }else /* 旗子用完了，不能插 */{
            JOptionPane.showMessageDialog(null,"标记已用尽","错误操作",JOptionPane.PLAIN_MESSAGE);
        }
    }
    /* 显示雷区 */
    public void showBomb(){
        for (int r = 0;r < rows;++r){
            for(int c = 0;c < cols; ++c){
                btns[r][c].setVisible(false);/* 隐藏label */
                label[r][c].setVisible(true);/* 显示按钮（这里只有隐藏了按钮才能显示按钮下面的label） */
            }
        }
    }
}
