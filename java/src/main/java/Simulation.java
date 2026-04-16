public class Simulation {
    private Dice dice;
    private Bins results;
    private int numberOfTosses;

    public Simulation(int numberOfDice, int numberOfTosses) {
        this.dice = new Dice(numberOfDice, 6);
        this.results = new Bins(numberOfDice, numberOfDice * 6);
        this.numberOfTosses = numberOfTosses;
    }

    public void runSimulation() {
        for (int i = 0; i < numberOfTosses; i++) {
            int roll = dice.roll();
            results.incrementBin(roll);
        }
    }

    public void printResults() {
    int total = results.getTotalRolls();

    System.out.println("Simulation of 2 dice tossed for " + total + " times.\n");

    for (int sum = 2; sum <= 12; sum++) {
        int count = results.getBin(sum);

        double percentage = ((double) count / total) * 100;

        System.out.printf("%2d: %7d (%.2f%%)%n",
                sum, count, percentage);
    }
}

    public static void main(String[] args) {
        Simulation sim = new Simulation(2, 1000000);
        sim.runSimulation();
        sim.printResults();
    }
}