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

    System.out.println("***");
    System.out.println("Simulation of 2 dice tossed for " + total + " times.");
    System.out.println("***\n");

    // Find max count for scaling
    int maxCount = 0;
    for (int sum = 2; sum <= 12; sum++) {
        int count = results.getBin(sum);
        if (count > maxCount) {
            maxCount = count;
        }
    }

    int maxStars = 50; // width of histogram

    for (int sum = 2; sum <= 12; sum++) {
        int count = results.getBin(sum);
        double percentage = (double) count / total;

        // Scale stars relative to max
        int starCount = (int) (((double) count / maxCount) * maxStars);

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < starCount; i++) {
            stars.append("*");
        }

        System.out.printf("%2d : %8d: %.2f %s%n",
                sum, count, percentage, stars.toString());
    }
}

    public static void main(String[] args) {
        Simulation sim = new Simulation(2, 1000000);
        sim.runSimulation();
        sim.printResults();
    }
}