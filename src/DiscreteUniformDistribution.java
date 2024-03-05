import java.util.Random;

public class DiscreteUniformDistribution extends Generator{
    public DiscreteUniformDistribution() {
        super();
    }

    public DiscreteUniformDistribution(double min, double max) {
        super(min, max);
    }

    public DiscreteUniformDistribution(double min, double max, double seed) {
        super(min, max, seed);
    }

    @Override
    public void setSeed(double seed) {
        super.setSeed(seed);
    }

    @Override
    public double nextNumber() {
        return random.nextInt((int)deltaMinMax + 1) + min;
    }
}
