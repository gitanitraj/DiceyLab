import java.util.Random;

public class Dice {
    private int numberOfDice;
    private int sides;
    private Random random;

    public Dice(int numberOfDice, int sides) {
        this.numberOfDice = numberOfDice;
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            total += random.nextInt(sides) + 1; // 1 to sides
        }
        return total;
    }
}