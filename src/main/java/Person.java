import java.util.Random;

public class Person extends Tile{


    Person(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Simulation simulation) {
        Random random = new Random();

        if (position.getX() == simulation.getWidth()-1 && simulation.getMap()[position.getY()+1][position.getX()] instanceof House){
            simulation.getCounter().setAlive(simulation.getCounter().getAlive()+1);
            destroy();

        }
        else if(position.getX() == simulation.getWidth()-1){
            position.setY(position.getY()+1);
            position.setX(0);
        }
        else{
            position.setX(position.getX()+1);
        }

        updatable = false;
    }

}
