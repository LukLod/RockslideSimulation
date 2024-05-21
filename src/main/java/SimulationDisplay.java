import javax.swing.*;
import java.awt.*;

public class SimulationDisplay extends JFrame{
    private Tile[][] map;
    private int width;
    private int height;
    private JPanel[][] mapDisplay;
    SimulationDisplay(Simulation simulation){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(simulation.getHeight(), simulation.getWidth()));
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        width = simulation.getWidth();
        height = simulation.getHeight();
        this.setSize(width*75, height*75);
        map = simulation.getMap();
        mapDisplay = new JPanel[height][width];
        for (int y=0; y<height; y++){
            for (int x=0; x<width; x++){
                mapDisplay[y][x] = new JPanel();
                mapDisplay[y][x].setBackground(Color.GRAY);
                this.add(mapDisplay[y][x]);
            }

        }

    }
    public void update(){
        for (int y=0; y<height; y++){
            for (int x=0; x<width; x++){
                if(map[y][x] instanceof House){
                    mapDisplay[y][x].setBackground(Color.GREEN);
                }

            }

        }
    }


}
