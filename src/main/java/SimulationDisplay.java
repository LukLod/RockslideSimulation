import javax.swing.*;
import java.awt.*;

public class SimulationDisplay extends JFrame{

    SimulationDisplay(Simulation simulation){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(simulation.getHeight(), simulation.getWidth()));
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setSize(simulation.getWidth()*75, 75*simulation.getHeight());
    }

}
