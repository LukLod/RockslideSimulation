public class Simulation {

    private final int HEIGHT = 10;
    private int width;
    private Tile[][] map;

    Simulation(int people, int width){
        this.width = width;
        map = new Tile[HEIGHT][width];
        for(int i=0; i < width; i++) {
            map[HEIGHT - 1][i]= new House(i,HEIGHT - 1);


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
