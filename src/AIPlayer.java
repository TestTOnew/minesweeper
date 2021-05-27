public class AIPlayer {
    private int score=0;
    private int mistake=0;

    private String name1="SB";
    private String name2="PS";

    public AIPlayer(){ }

    public String getName1() {
        return name1;
    }
    public String getName2() {
        return name2;
    }

    public void addScore(){
        score++;
    }




    public void costScore(){
        score--;
    }

    public void addMistake() { mistake++; }

    public int getScore(){
        return score;
    }

    public int getMistake(){ return mistake; }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
