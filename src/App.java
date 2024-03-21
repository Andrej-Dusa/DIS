import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JPanel panelMain;
    private JTextField replicationsTextField;
    private JLabel zakladIstinyLabel;
    private JTextField istinaTextField;
    private JLabel seedLabel;
    private JTextField a1TextField;
    private JLabel strategiaLabel;
    private JComboBox strategiaComboBox;
    private JButton startButton;
    private JButton pauseButton;
    private JPanel chartPanel;
    private Thread simulationThread;


    public App() {
        this.setContentPane(panelMain);
        this.setTitle("Monte Carlo");
        this.setSize(400, 200);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        this.setVisible(true);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int strategy = Integer.parseInt(strategiaComboBox.getSelectedItem().toString());
                double numberOfReplications = Double.parseDouble(replicationsTextField.getText());
                int addToChart = 1;

                if (numberOfReplications * 0.7 > 1000 ) {
                    addToChart = (int) ((numberOfReplications * 0.7) / 1000);
                }

                if (strategy == 1) {
                    MC_S1 mc_s1 = new MC_S1();
                    mc_s1.setChartPanel(chartPanel);
                    mc_s1.setAddToChart(addToChart);
                    mc_s1.setAllReplications((int)numberOfReplications);
                    simulationThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mc_s1.runSimulation((int)numberOfReplications);
                        }
                    });
                    simulationThread.start();
                } else if (strategy == 2) {
                    MC_S2 mc_s2 = new MC_S2();
                } else {
                    MC_S3 mc_s3 = new MC_S3();
                }

            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pause the simulation by interrupting the simulation thread
                if (simulationThread != null) {
                    simulationThread.interrupt();
                }
            }
        });
    }
}
