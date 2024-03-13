import java.util.Random;

public class MC_S1 extends Simulation{

    private DiscreteUniformDistribution dUD;
    private ContinousEmpiricalDistribution cED;
    private ContinousUniformDistribution cUD;
    private double sum;
    private int numberOfRunnedReplications;
    Random seedGenerator;
    public MC_S1() {
        seedGenerator = new Random();
        seedGenerator.setSeed(1);
        dUD = new DiscreteUniformDistribution(1,4, seedGenerator);
        cED = new ContinousEmpiricalDistribution(seedGenerator,0.1, 0.3, 0.1, 0.3,0.8,0.35,0.8,1.2,0.2,1.2,2.5,0.15,2.5,3.8,0.15,3.8,4.8,0.05);
        cUD = new ContinousUniformDistribution(0.9,2.2, seedGenerator);
    }

    @Override
    void beforeReplications() {
        numberOfRunnedReplications = 0;
        sum = 0;
    }

    @Override
    void afterReplications() {
        System.out.println(numberOfRunnedReplications + " : " + sum/numberOfRunnedReplications);
    }

    @Override
    void simulate() {
        double interest = 0.0;
        double years = 10.0;
        double HU = 100000;

        interest = dUD.nextNumber() * 0.01;
        double monthlyPayment = countMonthlyPayment(10, interest, HU);
        sum += monthlyPayment * 5 * 12;
        double principalBalance = countPrincipalBalance(10, 5, interest, HU);
        HU = principalBalance;

        interest = cED.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(5, interest, HU);
        sum += monthlyPayment * 12 * 3;
        principalBalance = countPrincipalBalance(5, 3, interest, HU);
        HU = principalBalance;

        interest = cUD.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(2, interest, HU);
        sum += monthlyPayment * 12 * 1;
        principalBalance = countPrincipalBalance(2, 1, interest, HU);
        HU = principalBalance;

        interest = cUD.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(1, interest, HU);
        sum += monthlyPayment * 12 * 1;
        principalBalance = countPrincipalBalance(1, 1, interest, HU);
        HU = principalBalance;

        numberOfRunnedReplications++;
        //System.out.println(numberOfRunnedReplications + " : " + sum/numberOfRunnedReplications);
    }

    public double countMonthlyPayment(double years, double interest, double HU) {
        double monthlyInterest = interest / 12.0;
        double result = (HU * monthlyInterest * Math.pow(1 + monthlyInterest, years * 12.0))/(Math.pow(1 + monthlyInterest, years * 12.0) - 1);
        return result;
    }

    public double countPrincipalBalance(double years, double yearsPayed, double interest, double HU) {
        double monthlyInterest = interest / 12.0;
        double result = HU *((Math.pow(1 + monthlyInterest, years * 12) - Math.pow(1 + monthlyInterest, yearsPayed * 12.0))/(Math.pow(1 + monthlyInterest, years * 12) - 1));
        return  result;
    }
}
