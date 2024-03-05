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

    @Override
    public void setSeed(double seed) {
        super.setSeed(seed);
    }

    @Override
    public double nextNumber() {
        return super.nextNumber();
    }
}
