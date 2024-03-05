public class Main {
    public static void main(String[] args) {
        DiscreteUniformDistribution disDU = new DiscreteUniformDistribution(1,4, 1);
        ContinousUniformDistribution disCU = new ContinousUniformDistribution(0.3,5, 1);
        ContinousEmpiricalDistribution disCE = new ContinousEmpiricalDistribution(
                1,0.1, 0.3, 0.1, 0.3,0.8,0.35,0.8,1.2,0.2,1.2,2.5,0.15,2.5,3.8,0.15,3.8,4.8,0.05);

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": " + disDU.nextNumber());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": " + disCU.nextNumber());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": " + disCE.nextNumber());
        }

    }
}