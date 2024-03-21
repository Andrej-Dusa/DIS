import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        DiscreteUniformDistribution disDU = new DiscreteUniformDistribution(1,4, 1);
//        ContinousUniformDistribution disCU = new ContinousUniformDistribution(0.3,5, 1);
//        ContinousEmpiricalDistribution disCE = new ContinousEmpiricalDistribution(
//                1,0.1, 0.3, 0.1, 0.3,0.8,0.35,0.8,1.2,0.2,1.2,2.5,0.15,2.5,3.8,0.15,3.8,4.8,0.05);
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println((i + 1) + ": " + disDU.nextNumber());
//        }
//        System.out.println("---------------------------");
//        for (int i = 0; i < 100; i++) {
//            System.out.println((i + 1) + ": " + disCU.nextNumber());
//        }
//        System.out.println("---------------------------");
//        for (int i = 0; i < 100; i++) {
//            System.out.println((i + 1) + ": " + disCE.nextNumber());
//        }
        MC_S1 strategia1 = new MC_S1();
        //strategia1.runSimulation(100000);

        MC_S2 strategia2 = new MC_S2();
        //strategia2.runSimulation(100000000);

        MC_S3 strategia3 = new MC_S3();
        //strategia3.runSimulation(100000000);

        SwingUtilities.invokeLater(() -> {
            App app = new App();
        });
    }
}