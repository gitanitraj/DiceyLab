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
        System.out.println("Simulation results:");
        for (int sum = diceRollMin(); sum <= diceRollMax(); sum++) {
            int count = results.getBin(sum);
            System.out.println(sum + ": " + count);
        }
    }

    private int diceRollMin() {
        return 2; // min for 2 dice
    }

    private int diceRollMax() {
        return 12; // max for 2 dice
    }
}
