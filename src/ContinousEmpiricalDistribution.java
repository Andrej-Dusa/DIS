import java.util.ArrayList;
import java.util.Random;

public class ContinousEmpiricalDistribution extends Generator{
    private ArrayList<Random> listOfGenerators;

    private ArrayList<Double> minsOfGenerators;
    private ArrayList<Double> maxsOfGenerators;
    private ArrayList<Double> probabilitiesOfGenerators;

    public ContinousEmpiricalDistribution() {
        super();
        minsOfGenerators.add(min);
        maxsOfGenerators.add(max);
        probabilitiesOfGenerators.add(1.0);
        Random newRandom = new Random();
        newRandom.setSeed(generatorOfSeeds.nextLong());
        listOfGenerators.add(newRandom);
    }

    public ContinousEmpiricalDistribution(double min, double max) {
        super(min, max);
        minsOfGenerators.add(min);
        maxsOfGenerators.add(max);
        probabilitiesOfGenerators.add(1.0);
        Random newRandom = new Random();
        newRandom.setSeed(generatorOfSeeds.nextLong());
        listOfGenerators.add(newRandom);
    }

    public ContinousEmpiricalDistribution(double min, double max, double seed) {
        super(min, max, seed);
        minsOfGenerators.add(min);
        maxsOfGenerators.add(max);
        probabilitiesOfGenerators.add(1.0);
        Random newRandom = new Random();
        newRandom.setSeed(generatorOfSeeds.nextLong());
        listOfGenerators.add(newRandom);
    }

    public ContinousEmpiricalDistribution(double... params) {
        double minValue = 0.0;
        double maxValue = 0.0;
        double probability = 0.0;
        double sumProbability = 0.0;
        for (int i = 0; i < params.length ; i++) {
            switch (i % 3) {
                case 0 :
                    minValue = params[i];
                    minsOfGenerators.add(minValue);
                    break;
                case 1:
                    maxValue = params[i];
                    maxsOfGenerators.add(maxValue);
                    break;
                case 2:
                    probability = params[i];
                    sumProbability += probability;
                    Random newRandom = new Random();
                    newRandom.setSeed(generatorOfSeeds.nextLong());
                    listOfGenerators.add(newRandom);
                    probabilitiesOfGenerators.add(sumProbability);
                    break;
            }
        }

        if (1 - sumProbability > 0.00001) {
            System.out.println("Sucet pravdepodobnosti musi byt rovny 1!!!");
        }

    }

    @Override
    public double nextNumber() {
        double generatedProbability = random.nextDouble();
        int index = 0;
        for (int i = 0; i < probabilitiesOfGenerators.size(); i++) {
            if (probabilitiesOfGenerators.get(i) > generatedProbability) {
                index = i;
                break;
            }
        }
        double delta = maxsOfGenerators.get(index) - minsOfGenerators.get(index);
        return listOfGenerators.get(index).nextDouble(delta) + minsOfGenerators.get(index);
    }
}
