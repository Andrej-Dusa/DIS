abstract class Simulation {

    abstract void beforeReplications();
    abstract void afterReplications();
    abstract void simulate();
    public void runSimulation(int numberOfReplications) {
        beforeReplications();
        for (int i = 0; i < numberOfReplications; i++) {
            simulate();
        }
        afterReplications();
    }
}
