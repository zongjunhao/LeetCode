public class MySqrt {
    public int mySqrt(int x) {
        double result = Math.sqrt(x);
        return (int) result;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(16));
    }
}
