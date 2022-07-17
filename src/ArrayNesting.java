import java.util.Arrays;

public class ArrayNesting {
    // public int arrayNesting(int[] nums) {
    //     // 最大长度
    //     int maxLength = 0;
    //     // 当前最大长度
    //     int tempLength = 0;
    //     // 记录当前是否出现过，初始化置否
    //     boolean[] appeared = new boolean[nums.length];
    //     Arrays.fill(appeared, false);
    //     // 循环判断
    //     for (int i = 0; i < nums.length; i++) {
    //         // 当前位置没有出现过则进入判断，出现过则遍历下一个数
    //         if (!appeared[i]) {
    //             // 记录当前位置为出现过，且长度+1
    //             appeared[i] = true;
    //             tempLength++;
    //             // 进入数组嵌套
    //             int nextIndex = nums[i];
    //             while (true) {
    //                 // 下一个索引没有出现过则继续循环，否则退出循环
    //                 if (!appeared[nextIndex]) {
    //                     appeared[nextIndex] = true;
    //                     tempLength++;
    //                     nextIndex = nums[nextIndex];
    //                 } else {
    //                     break;
    //                 }
    //             }
    //             if (tempLength > maxLength) {
    //                 maxLength = tempLength;
    //             }
    //             tempLength = 0;
    //         }
    //     }
    //     return maxLength;
    // }
    public int arrayNesting(int[] nums) {
        // 最大长度
        int maxLength = 0;
        // 当前最大长度
        int tempLength = 0;
        // 记录当前是否出现过，初始化置否
        boolean[] appeared = new boolean[nums.length];
        // 循环判断
        for (int i = 0; i < nums.length; i++) {
            while (!appeared[i]) {
                appeared[i] = true;
                tempLength++;
                i = nums[i];
            }
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
            tempLength = 0;

        }
        return maxLength;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int[] inputArray = new int[]{5, 4, 0, 3, 1, 6, 2};
        // int[] inputArray = new int[]{0, 1, 2};
        System.out.println(arrayNesting.arrayNesting(inputArray));
    }
}
