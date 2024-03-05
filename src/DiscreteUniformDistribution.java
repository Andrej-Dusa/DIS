import java.util.Random;

public class DiscreteUniformDistribution extends Generator{

    @Override
    public double nextNumber() {
        return random.nextInt((int)deltaMinMax) + min;
    }
}
