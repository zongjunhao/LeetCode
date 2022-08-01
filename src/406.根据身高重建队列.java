/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

import java.util.*;

// @lc code=start
class Solution {
    // public int[][] reconstructQueue(int[][] people) {
    //     Comparator<int[]> comparator = new Comparator<int[]>() {
    //         @Override
    //         public int compare(int[] o1, int[] o2) {
    //             if (o1[0] < o2[0]) {
    //                 return -1;
    //             } else if (o1[0] == o2[0]) {
    //                 return Integer.compare(o2[1], o1[1]);
    //             } else {
    //                 return 1;
    //             }
    //         }
    //     };
    //     Arrays.sort(people, comparator);
    //     int numPeople = people.length;
    //     int[][] result = new int[numPeople][];
    //     for (int[] person : people) {
    //         // 此人前面比此人高或身高相等的人数
    //         int numsHigher = person[1];
    //         int currentNum = 0;
    //         for (int i = 0; i < numPeople; i++) {
    //             if (result[i] == null){
    //                 if (currentNum == numsHigher){
    //                     result[i] = person;
    //                     break;
    //                 }
    //                 currentNum++;
    //             }
    //         }
    //     }
    //     return result;
    // }

    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        };
        Arrays.sort(people, comparator);
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] person :
                people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
    }
}
// @lc code=end

