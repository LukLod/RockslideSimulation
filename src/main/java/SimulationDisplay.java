import javax.swing.*;
import java.awt.*;

public class SimulationDisplay extends JFrame{
    private Tile[][] map;
    private JPanel[][] mapDisplay;
    SimulationDisplay(Simulation simulation){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(simulation.getHeight(), simulation.getWidth()));
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setSize(simulation.getWidth()*75, 75*simulation.getHeight());
        map= simulation.getMap();
        mapDisplay = new JPanel[simulation.getWidth()][simulation.getHeight()];
        for(int i=0; i<simulation.getWidth(); i++){
            for(int j=0; j<simulation.getHeight(); j++){
                mapDisplay[i][j] = new JPanel();
                mapDisplay[i][j].setBackground(Color.GRAY);
                this.add(mapDisplay[i][j]);
            }

        }

    }
    public void Update(Simulation simulation){

    }


}
