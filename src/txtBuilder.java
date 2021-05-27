import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class txtBuilder {
    private static JLabel gameMode;
    public txtBuilder() {
        JFrame f = new JFrame("存档");
        f.setBounds(600,200,340,480);
        f.setLayout(null);
        //f.setDefaultCloseOperation(3);

        gameMode=new JLabel("Difficulty Choosing");
        gameMode.setBounds(109,20,200,20);
        f.add(gameMode);

        JButton write1=new JButton("存档一写入");
        JButton read1=new JButton("存档一读取");
        JButton write2=new JButton("存档二写入");
        JButton read2=new JButton("存档二读取");
        JButton write3=new JButton("存档三写入");
        JButton read3=new JButton("存档三读取");
        JButton write4=new JButton("存档四写入");
        JButton read4=new JButton("存档四读取");

        write1.setBounds(51,100,100,25);
        write2.setBounds(51,180,100,25);
        write3.setBounds(51,260,100,25);
        write4.setBounds(51,340,100,25);

        read1.setBounds(151,100,100,25);
        read2.setBounds(151,180,100,25);
        read3.setBounds(151,260,100,25);
        read4.setBounds(151,340,100,25);


        write1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    write("1");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        write2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    write("2");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        write3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    write("3");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        write4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    write("4");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        read1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    GamePanel.setState(readst("1"));
                    //GamePanel.setBtns(readbtn("1"));
                    GamePanel.setClick(readcli("1"));
                    //GamePanel.setLabel(readlab("1"));
                    //GamePanel.setLabeltext(readlabt("1"));
                    GamePanel.setSBScore(readSBScore("1"));
                    GamePanel.setSBMistake(readSBMistake("1"));
                    GamePanel.setPSScore(readPSScore("1"));
                    GamePanel.setPSMistake(readPSMistake("1"));

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        read2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    GamePanel.setState(readst("2"));
                    //GamePanel.setBtns(readbtn("2"));
                    GamePanel.setClick(readcli("2"));
                    //GamePanel.setLabel(readlab("2"));
                    //GamePanel.setLabeltext(readlabt("2"));
                    GamePanel.setSBScore(readSBScore("2"));
                    GamePanel.setSBMistake(readSBMistake("2"));
                    GamePanel.setPSScore(readPSScore("2"));
                    GamePanel.setPSMistake(readPSMistake("2"));

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        read3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    GamePanel.setState(readst("3"));
                    //GamePanel.setBtns(readbtn("3"));
                    GamePanel.setClick(readcli("3"));
                    //GamePanel.setLabel(readlab("3"));
                    //GamePanel.setLabeltext(readlabt("3"));
                    GamePanel.setSBScore(readSBScore("3"));
                    GamePanel.setSBMistake(readSBMistake("3"));
                    GamePanel.setPSScore(readPSScore("3"));
                    GamePanel.setPSMistake(readPSMistake("3"));

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        read4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    GamePanel.setState(readst("4"));
                    //GamePanel.setBtns(readbtn("4"));
                    GamePanel.setClick(readcli("4"));
                    //GamePanel.setLabel(readlab("4"));
                    //GamePanel.setLabeltext(readlabt("4"));
                    GamePanel.setSBScore(readSBScore("4"));
                    GamePanel.setSBMistake(readSBMistake("4"));
                    GamePanel.setPSScore(readPSScore("4"));
                    GamePanel.setPSMistake(readPSMistake("4"));

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        write1.setVisible(true);
        write2.setVisible(true);
        write3.setVisible(true);
        write4.setVisible(true);

        read1.setVisible(true);
        read2.setVisible(true);
        read3.setVisible(true);
        read4.setVisible(true);

        f.add(write1);
        f.add(write2);
        f.add(write3);
        f.add(write4);
        f.add(read1);
        f.add(read2);
        f.add(read3);
        f.add(read4);

        f.setVisible(true);
    }

    public static void write(String a) throws IOException {

        File file =new File("D:\\lzc3\\txt\\"+a+".txt");
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(GamePanel.SB1.getScore());
        bw.write(GamePanel.SB1.getMistake());
        bw.write(GamePanel.PS1.getScore());
        bw.write(GamePanel.PS1.getMistake());

        File file1=new File("D:\\lzc3\\txt\\"+a+"1.txt");
        FileWriter fw1=new FileWriter(file1);
        BufferedWriter bw1=new BufferedWriter(fw1);
        int[][] btn =GamePanel.getBtnsvisible();
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                bw1.write(String.valueOf(btn[i][j]));
            }
        }

        File file2=new File("D:\\lzc3\\txt\\"+a+"2.txt");
        FileWriter fw2=new FileWriter(file2);
        BufferedWriter bw2=new BufferedWriter(fw2);
        int[][] state =GamePanel.getState();
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                bw2.write(String.valueOf(state[i][j]));
            }
        }

        File file3=new File("D:\\lzc3\\txt\\"+a+"3.txt");
        FileWriter fw3=new FileWriter(file3);
        BufferedWriter bw3=new BufferedWriter(fw3);
        int[][] lab =GamePanel.getLabelvisible();
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                bw3.write(String.valueOf(lab[i][j]));
            }
        }

        File file4=new File("D:\\lzc3\\txt\\"+a+"4.txt");
        FileWriter fw4=new FileWriter(file4);
        BufferedWriter bw4=new BufferedWriter(fw4);
        int[][] labt =GamePanel.getLabel();
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                bw4.write(String.valueOf(labt[i][j]));
            }
        }

        File file5=new File("D:\\lzc3\\txt\\"+a+"5.txt");
        FileWriter fw5=new FileWriter(file5);
        BufferedWriter bw5=new BufferedWriter(fw5);
        int[][] cli =GamePanel.getClick();
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                bw5.write(String.valueOf(cli[i][j]));
            }
        }
        bw1.close();bw2.close();bw3.close();bw4.close();bw5.close();

    }


    public static int[][] readbtn(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+"1.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int[][] btn = new int[GamePanel.getRows()][GamePanel.getCols()];
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                btn[i][j] = br.read();
            }
        }
        return btn;
    }

    public static int[][] readlab(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+"3.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int[][] lab = new int[GamePanel.getRows()][GamePanel.getCols()];
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j <GamePanel.getCols(); j++) {
                lab[i][j] = br.read();
            }
        }
        return lab;
    }

    public static int[][] readlabt(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+"4.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int[][] labt = new int[GamePanel.getRows()][GamePanel.getCols()];
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                labt[i][j] = br.read();
            }
        }
        return labt;
    }

    public static int[][] readst(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+"2.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int[][] st = new int[GamePanel.getRows()][GamePanel.getCols()];
        for (int i = 0; i <GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                st[i][j]= br.read();
            }
        }
        return st;
    }

    public static int[][] readcli(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+"5.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int[][] cli = new int[GamePanel.getRows()][GamePanel.getCols()];
        for (int i = 0; i < GamePanel.getRows(); i++) {
            for (int j = 0; j < GamePanel.getCols(); j++) {
                cli[i][j] = (byte) br.read();
                    }
                }
        return cli;
    }

    public static int readSBScore(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+".txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int sbscore=br.read();
        int sbmistake=br.read();
        int psscore=br.read();
        int psmistake=br.read();
        return sbscore;
    }
    public static int readSBMistake(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+".txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int sbscore=br.read();
        int sbmistake=br.read();
        int psscore=br.read();
        int psmistake=br.read();
        return sbmistake;
    }
    public static int readPSScore(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+".txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int sbscore=br.read();
        int sbmistake=br.read();
        int psscore=br.read();
        int psmistake=br.read();
        return psscore;
    }
    public static int readPSMistake(String a) throws IOException {
        File file=new File("D:\\lzc3\\txt\\"+a+".txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int sbscore=br.read();
        int sbmistake=br.read();
        int psscore=br.read();
        int psmistake=br.read();
        return psmistake;
    }


}
