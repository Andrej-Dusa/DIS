public class DeterministicDistribution implements IGenerator{
    private double number;
    public DeterministicDistribution() {
        number = 1;
    }

    public DeterministicDistribution(double number) {
        this.number = number;
    }

    @Override
    public double nextNumber() {
        return number;
    }
}
