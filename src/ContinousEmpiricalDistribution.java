import java.util.ArrayList;
import java.util.Random;

public class ContinousEmpiricalDistribution extends Generator{
    private ArrayList<Random> listOfGenerators;

    private ArrayList<Double> parametersOfGenerators;

    public ContinousEmpiricalDistribution() {
        super();
    }

    public ContinousEmpiricalDistribution(double min, double max) {
        super(min, max);
    }

    public ContinousEmpiricalDistribution(double min, double max, double seed) {
        super(min, max, seed);
    }

    @Override
    public double nextNumber() {
        return super.nextNumber();
    }
}
