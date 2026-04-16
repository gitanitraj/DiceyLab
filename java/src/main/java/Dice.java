import java.util.Random;

public class Dice {
    private int value;
    private Random random;

    public Dice() {
        random = new Random();
    }

    public void roll() {
        value = random.nextInt(6) + 1; // 1–6
    }

    public int getValue() {
        return value;
    }

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.roll();
        System.out.println("Rolled: " + dice.getValue());
    }
}

while (true) {
    int roll = dice.roll();
    System.out.println("You rolled: " + roll);
}
}

