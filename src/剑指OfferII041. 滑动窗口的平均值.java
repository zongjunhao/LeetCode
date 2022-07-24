import java.util.Arrays;

class MovingAverage {
    double[] doubleArray;
    int filledPosNum = 0;
    int pos = 0;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        this.doubleArray = new double[size];
        Arrays.fill(doubleArray, 0);
    }

    public double next(int val) {
        if (filledPosNum < size) {
            filledPosNum++;
        }
        doubleArray[pos] = val;
        pos = (pos + 1) % size;
        double sum = 0;
        for (int i = 0; i < filledPosNum; i++) {
            sum += doubleArray[i];
        }
        return sum / filledPosNum;
    }

    public static void main(String[] args) {
        int size = 3;
        MovingAverage movingAverage = new MovingAverage(size);
        System.out.println(movingAverage.next(1));  // 返回 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // 返回 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // 返回 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // 返回 6.0 = (10 + 3 + 5) / 3

    }
}