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
    private Thread simulationThread;


    public App() {
        this.setContentPane(panelMain);
        this.setTitle("Monte Carlo");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int strategy = Integer.parseInt(strategiaComboBox.getSelectedItem().toString());
                int numberOfReplications = Integer.parseInt(replicationsTextField.getText());
                if (strategy == 1) {
                    MC_S1 mc_s1 = new MC_S1();
                    simulationThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mc_s1.runSimulation(numberOfReplications);
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
