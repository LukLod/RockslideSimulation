import java.util.Random;

public class Boulder extends Tile{
    Boulder(int x, int y) {
        super(x, y);
    }
    @Override
    public void update(Simulation simulation) {

        Random random = new Random();

        if (simulation.getMap()[position.getY()+1][position.getX()] instanceof House){
            position.setY(0);
            position.setX(random.nextInt(0, simulation.getWidth()));
        }
        else{
            position.setY(position.getY()+1);
        }

        updatable = false;
    }


}
