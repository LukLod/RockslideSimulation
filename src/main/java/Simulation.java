public class Simulation {

    private final int HEIGHT = 10;
    private int width;
    private Tile[][] map;

    Simulation(int people, int width){
        this.width = width;
        map = new Tile[width][HEIGHT];
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return HEIGHT;
    }


}
