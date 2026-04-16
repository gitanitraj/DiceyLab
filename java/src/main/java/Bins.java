
public class Bins {
    private int[] bins;
    private int min; // minimum sum
    private int max; // maximum sum

    public Bins(int min, int max) {
        this.min = min;
        this.max = max;
        this.bins = new int[max - min + 1]; // array index = sum - min
    }

    public void incrementBin(int sum) {
        if (sum < min || sum > max) {
            throw new IllegalArgumentException("Sum out of range");
        }
        bins[sum - min]++;
    }

    public int getBin(int sum) {
        if (sum < min || sum > max) {
            throw new IllegalArgumentException("Sum out of range");
        }
        return bins[sum - min];
    }

    public int getTotalRolls() {
        int total = 0;
        for (int count : bins) {
            total += count;
        }
        return total;
    }
}
