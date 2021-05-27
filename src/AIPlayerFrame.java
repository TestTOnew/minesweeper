import javax.swing.*;

public class AIPlayerFrame extends JFrame {
    static private JLabel gameMode;


    public AIPlayerFrame(){
        AIMineClearance.setBomb(100);
        AIMineClearance.setx(100);
        AIMineClearance.sety(100);
        AIMineClearance.setWidth(400);
        AIMineClearance.setHeight(400);
        AIMineClearance.setRow(20);
        AIMineClearance.setCol(20);
        new AIMineClearance();
        //AIMineClearance.setn(1);


    }

}
