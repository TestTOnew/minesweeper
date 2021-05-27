import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Start mainFrame = new Start();//创建窗口？？

            // mainFrame.setVisible(true);
        });

        new Thread(()->{while(true) {Music.playMusic();} //while中的true可换成参数来控制音乐的停止播放
        }).start();



    }
}
