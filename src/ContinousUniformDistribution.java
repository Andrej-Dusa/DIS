import java.util.Random;

public class ContinousUniformDistribution extends Generator{
    public ContinousUniformDistribution() {
        super();
    }

    public ContinousUniformDistribution(double min, double max) {
        super(min, max);
    }

    public ContinousUniformDistribution(double min, double max, double seed) {
        super(min, max, seed);
    }

    public ContinousUniformDistribution(double min, double max, Random seedGenerator) {
        super(min, max, seedGenerator);
    }

    @Override
    public void setSeed(double seed) {
        super.setSeed(seed);
    }

    @Override
    public double nextNumber() {
        return super.nextNumber();
    }
}
