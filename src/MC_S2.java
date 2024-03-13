import java.util.Random;

public class MC_S2 extends MC_S1{

    private DiscreteUniformDistribution dUD;
    private DeterministicDistribution dD;
    private ContinousUniformDistribution cUD;

    private ContinousUniformDistribution cUD2;

    public MC_S2() {
        seedGenerator = new Random();
        seedGenerator.setSeed(1);
        dUD = new DiscreteUniformDistribution(1,4, seedGenerator);
        dD = new DeterministicDistribution(1.3);
        cUD = new ContinousUniformDistribution(0.3,5, seedGenerator);
        cUD2 = new ContinousUniformDistribution(0.9,2.2, seedGenerator);
    }

    @Override
    void beforeReplications() {
        super.beforeReplications();
    }

    @Override
    void afterReplications() {
        super.afterReplications();
    }

    @Override
    void simulate() {
        double HU = 100000;

        double interest = dUD.nextNumber() * 0.01;
        double monthlyPayment = countMonthlyPayment(10, interest, HU);
        sum += monthlyPayment * 12 * 3;
        double principalBalance = countPrincipalBalance(10, 3, interest, HU);
        HU = principalBalance;

        interest = cUD.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(7, interest, HU);
        sum += monthlyPayment * 12 * 3;
        principalBalance = countPrincipalBalance(7, 3, interest, HU);
        HU = principalBalance;

        interest = dD.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(4, interest, HU);
        sum += monthlyPayment * 12 * 3;
        principalBalance = countPrincipalBalance(4, 3, interest, HU);
        HU = principalBalance;

        interest = cUD2.nextNumber() * 0.01;
        monthlyPayment = countMonthlyPayment(1, interest, HU);
        sum += monthlyPayment * 12 * 1;
        principalBalance = countPrincipalBalance(1, 1, interest, HU);
        HU = principalBalance;

        numberOfRanReplications++;
    }


    @Override
    public double countMonthlyPayment(double years, double interest, double HU) {
        return super.countMonthlyPayment(years, interest, HU);
    }

    @Override
    public double countPrincipalBalance(double years, double yearsPayed, double interest, double HU) {
        return super.countPrincipalBalance(years, yearsPayed, interest, HU);
    }
}
