
import java.util.Random;
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
        placeHumans(people, width);
        placeBoulder(width);
    }

    private void placeBoulder(int width){
        Random random = new Random();
        int x = random.nextInt(0, width );
        map[0][x] = new Boulder(x, 0);
    }

    private void placeHumans(int people, int width){
        int peopleCount = 0;
        int spawnableSpaces = (HEIGHT-2)*(width-2);
        Random random = new Random();
        for(int i=0; i < people; i++){

            while(peopleCount < people && peopleCount < spawnableSpaces) {
                int y = random.nextInt(1, HEIGHT - 1);
                int x = random.nextInt(1, width - 1);
                if(!(map[y][x] instanceof Person)){
                    map[y][x] = new Person(x, y);
                    peopleCount++;
                }
            }
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

    public void update(){
        for(Tile[] row : map){
            for(Tile tile : row){
                if(tile != null && tile.isUpdatable()){
                    int oldX = tile.getX();
                    int oldY = tile.getY();
                    tile.update(this);
                    int newX = tile.getX();
                    int newY = tile.getY();
                    if(oldX  != newX || oldY != newY) {
                        map[newY][newX] = tile;
                        map[oldY][oldX] = null;
                    }
                }
            }
        }

        for(Tile[] row : map){
            for(Tile tile : row){
                if(tile != null && !tile.isUpdatable()){
                    tile.setUpdatability();
                }
            }
        }

    }


}
