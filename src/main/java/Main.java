import javax.swing.*;
import java.awt.*;


public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        JButton generatorButton = new JButton();
        generatorButton.setText("Wygeneruj symulacje");

        JLabel title = new JLabel();
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        title.setText("Title");

        JLabel heightInfo = new JLabel();
        heightInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        heightInfo.setText("Stala wyskosc symulacji: 10");

        JPanel heightInfoHolder = new JPanel();
        heightInfoHolder.setBackground(Color.LIGHT_GRAY);
        heightInfoHolder.setLayout(new BorderLayout());
        heightInfoHolder.add(heightInfo);

        JSlider widthSlider = new JSlider();
        widthSlider.setMinimum(4);
        widthSlider.setMaximum(20);
        widthSlider.setValue(10);
        widthSlider.setPaintTicks(true);
        widthSlider.setMinorTickSpacing(1);
        widthSlider.setPaintTrack(true);
        widthSlider.setMajorTickSpacing(2);
        widthSlider.setPaintLabels(true);

        JSlider peopleSlider = new JSlider();
        peopleSlider.setMinimum(1);
        peopleSlider.setMaximum(8);
        peopleSlider.setValue(4);
        peopleSlider.setPaintTicks(true);
        peopleSlider.setMinorTickSpacing(1);
        peopleSlider.setPaintTrack(true);
        peopleSlider.setMajorTickSpacing(1);
        peopleSlider.setPaintLabels(true);


        JPanel rightMenu = new JPanel();
        rightMenu.setBackground(Color.LIGHT_GRAY);
        rightMenu.setLayout(new GridLayout(4, 1));
        rightMenu.setPreferredSize(new Dimension(200, 750));
        rightMenu.add(peopleSlider);
        rightMenu.add(widthSlider);
        rightMenu.add(heightInfoHolder);
        rightMenu.add(generatorButton);

        JPanel titleCard = new JPanel();
        titleCard.setBackground(Color.LIGHT_GRAY);
        titleCard.setLayout(new FlowLayout());
        titleCard.setPreferredSize(new Dimension(200, 50));
        titleCard.add(title);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        frame.setSize(1000, 750);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);
        frame.add(titleCard, BorderLayout.NORTH);
        frame.add(rightMenu, BorderLayout.EAST);

        generatorButton.addActionListener(e -> {
            try {
                generateSimulation(peopleSlider.getValue(), widthSlider.getValue());
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    public static void generateSimulation(int people, int width) throws Exception {
        Simulation symulacja = new Simulation(people, width);
        SimulationDisplay display = new SimulationDisplay(symulacja);
        Timer timer = new Timer(200, e->{
                display.update();
                symulacja.update();

            if(symulacja.getCounter().getAlive() + symulacja.getCounter().getDead() == symulacja.getCounter().getOverall()){
                ((Timer) e.getSource()).stop();
                JOptionPane.showMessageDialog(null, "Dead: " + symulacja.getCounter().getDead()+" , "+"Alive: " + symulacja.getCounter().getAlive());

            }
        });

        timer.start();





    }

}