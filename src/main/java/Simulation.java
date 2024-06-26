
import java.util.Random;
public class Simulation {

    private final int HEIGHT = 10;
    private int width;
    private Tile[][] map;
    private Counter counter = new Counter();

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
                    counter.setOverall(counter.getOverall()+1);
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
        for(int y = HEIGHT-1; y>=0; y--){
            for(int x = width-1; x>=0; x--){
                if(map[y][x] != null && map[y][x].isUpdatable()){
                    int oldX = map[y][x].getX();
                    int oldY = map[y][x].getY();
                    map[y][x].update(this);
                    if(!map[y][x].isToBeDestroyed()){
                        int newX = map[y][x].getX();
                        int newY = map[y][x].getY();
                        if(oldX  != newX || oldY != newY) {
                            map[newY][newX] = map[y][x];
                            map[oldY][oldX] = null;
                        }
                    }
                    else {
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

    public Counter getCounter(){
        return counter;
    }


}
