import java.util.Arrays;

public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        int[] strongestArray = new int[k];
        int arrayPos = 0;
        int minPos = 0;
        int maxPos = arr.length - 1;
        Arrays.sort(arr);
        int midVal = arr[maxPos / 2];
        for (int i = 0; i < k; i++) {
            int diffMin = midVal - arr[minPos];
            int diffMax = arr[maxPos] - midVal;
            if (diffMax >= diffMin) {
                strongestArray[arrayPos] = arr[maxPos];
                arrayPos++;
                maxPos--;
            } else {
                strongestArray[arrayPos] = arr[minPos];
                arrayPos++;
                minPos++;
            }
        }
        return strongestArray;
    }

    public static void main(String[] args) {
        GetStrongest getStrongest = new GetStrongest();
        int[] arr = new int[]{-7, 22, 17, 3};
        int k = 2;
        System.out.println(Arrays.toString(getStrongest.getStrongest(arr, k)));
    }
}
