import javax.swing.*;

public class DIYGameOver {
    static private JLabel Miss1,Miss2,Point1,Point2,Winner,Title,Player1,Player2,backGround;
    private static ImageIcon gameover1 = new ImageIcon("D:\\lzc3\\图片2\\gameover.png");
    Player SB=new Player();
    Player PS=new Player();

    public DIYGameOver(){
        JFrame f=new JFrame();
        f.setBounds(750,350,400,250);
        f.setLayout(null);
        //f.setDefaultCloseOperation(3);

        backGround=new JLabel(gameover1);
        backGround.setBounds(-10,-22,400,250);
        f.add(backGround);

        Miss1 =new JLabel(String.valueOf(DIYMineClearance.SB.getMistake()));
        Miss2 =new JLabel(String.valueOf(DIYMineClearance.PS.getMistake()));
        Point1 =new JLabel(String.valueOf(DIYMineClearance.SB.getScore()));
        Point2 =new JLabel(String.valueOf(DIYMineClearance.PS.getScore()));
        Title =new JLabel("Score       Miss");
        Player1=new JLabel(DIYMineClearance.SB.getName1());
        Player2=new JLabel(DIYMineClearance.PS.getName2());

        if (DIYMineClearance.SB.getScore()>DIYMineClearance.PS.getScore()){
            Winner =new JLabel("胜利者是"+DIYMineClearance.SB.getName1()+" !");
        }
        else if (DIYMineClearance.SB.getScore()<DIYMineClearance.PS.getScore()){
            Winner =new JLabel("胜利者是"+DIYMineClearance.PS.getName2()+" ！");
        }

        else {
            if (DIYMineClearance.SB.getMistake()<DIYMineClearance.PS.getMistake()){
                Winner =new JLabel("胜利者是"+DIYMineClearance.SB.getName1()+" !!!!!!");
            }
            else if(DIYMineClearance.SB.getMistake()>DIYMineClearance.PS.getMistake()){
                Winner =new JLabel("胜利者是"+DIYMineClearance.PS.getName2()+" !!!!!!");
            }
            else {
                Winner =new JLabel("平局");//平局
            }
        }

        Miss1.setBounds(160,80,50,50);
        Miss2.setBounds(160,110,50,50);

        Point1.setBounds(110,80,50,50);
        Point2.setBounds(110,110,50,50);

        Title.setBounds(100,50,200,50);
        Player1.setBounds(50,80,100,50);
        Player2.setBounds(50,110,100,50);
        Winner.setBounds(100,10,200,50);

        Miss1.setVisible(true);
        Miss2.setVisible(true);
        Point1.setVisible(true);
        Point2.setVisible(true);
        Winner.setVisible(true);
        Title.setVisible(true);
        Player1.setVisible(true);
        Player2.setVisible(true);


        backGround.add(Miss1);
        backGround.add(Miss2);
        backGround.add(Point1);
        backGround.add(Point2);
        backGround.add(Winner);
        backGround.add(Title);
        backGround.add(Player1);
        backGround.add(Player2);



        f.setVisible(true);
    }
}

