public class Counter {

    private int overall = 0;
    private int dead = 0;
    private int alive = 0;

    public int getDead(){
        return dead;
    }
    public int getAlive(){
        return alive;
    }
    public void setDead(int d){
        dead = d;
    }
    public void setAlive(int a){
        alive = a;
    }
    public int getOverall(){return overall;}
    public void setOverall(int o){overall = o;}

}
