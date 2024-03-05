import java.util.Random;

public class Generator implements IGenerator {
    protected double min;
    protected double max;
    protected double deltaMinMax;
    protected double seed;
    protected Random random;

    public Generator()  {
        random = new Random();
        min = 0;
        max = 1;
        deltaMinMax = max - min;
    }

    public Generator(double min, double max) {
        this.min = min;
        this.max = max;
        deltaMinMax = max - min;
        random = new Random();
    }

    public Generator(double min, double max, double seed) {
        this.min = min;
        this.max = max;
        this.seed = seed;
        deltaMinMax = max - min;
        random = new Random();
        random.setSeed((long)seed);
    }

    public double nextNumber() {
        return random.nextDouble(deltaMinMax) + min;
    }
}
