/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Map<Integer, List<Integer>> groups = new HashMap<>();
        // for (int i = 0; i < groupSizes.length; i++) {
        //     // if (groups.get(groupSizes[i]) == null) {
        //     //     List<Integer> list = new ArrayList<>();
        //     //     list.add(i);
        //     //     groups.put(groupSizes[i], list);
        //     // } else {
        //     //     List<Integer> list = groups.get(groupSizes[i]);
        //     //     list.add(i);
        //     // }
        //     groups.putIfAbsent(groupSizes[i], new ArrayList<>());
        //     groups.get(groupSizes[i]).add(i);
        // }
        // List<List<Integer>> groupList = new ArrayList<>();
        // // for (int key : groups.keySet()) {
        // //     List<Integer> allList = groups.get(key);
        // //     List<Integer> group = new ArrayList<>();
        // //     for (int i = 0; i < groups.get(key).size(); i++) {
        // //         if (group.size() < key) {
        // //             group.add(allList.get(i));
        // //             if (group.size() == key) {
        // //                 groupList .add(group);
        // //                 group = new ArrayList<>();
        // //             }
        // //         }
        // //     }
        // // }
        // for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
        //     int size = entry.getKey();
        //     List<Integer> people = entry.getValue();
        //     int groupCount = people.size() / size;
        //     for (int i = 0; i < groupCount; i++) {
        //         List<Integer> group = new ArrayList<>();
        //         int start = i * size;
        //         for (int j = 0; j < size; j++) {
        //             group.add(people.get(start + j));
        //         }
        //         groupList.add(group);
        //     }
        // }
        // return groupList;

        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> groupList = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            groups.putIfAbsent(groupSizes[i], new ArrayList<>());
            List<Integer> list = groups.get(groupSizes[i]);
            list.add(i);
            if (list.size() == groupSizes[i]) {
                groupList.add(list);
                groups.remove(groupSizes[i]);
            }
        }

        return groupList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        System.out.println(solution.groupThePeople(groupSizes));
    }
}
// @lc code=end

