public class Simulation {

    private final int HEIGHT = 10;
    private int width;
    private Tile[][] map;

    Simulation(int people, int width){
        this.width = width;
        map = new Tile[width][HEIGHT];
        for(int i=0; i < width; i++) {
            map[i][HEIGHT - 1]= new House(i,HEIGHT - 1);


        }
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return HEIGHT;
    }
    public Tile[][] getMap(){
        return map;
    }

}
