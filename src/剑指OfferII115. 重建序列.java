import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class SequenceReconstruction {
    // public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
    //     // 子序列个数
    //     int numOfSequences = sequences.length;
    //     // 每个子序列长度
    //     int sequenceLength = sequences[0].length;
    //     // nums指针
    //     int pointerOfNums = 0;
    //     // 每个子序列的指针
    //     int[] pointers = new int[numOfSequences];
    //     while (true) {
    //         // nums当前指针位置的数字
    //         int currentNum = nums[pointerOfNums];
    //         boolean flag = false;
    //         for (int i = 0; i < numOfSequences; i++) {
    //             // 当前序列已经遍历结束
    //             if (pointers[i] >= sequenceLength) {
    //                 continue;
    //             }
    //             // 当前序列指针位置的数字与nums指针位置的数字相同
    //             if (sequences[i][pointers[i]] == currentNum) {
    //                 pointers[i]++;
    //                 flag = true;
    //             }
    //             if (!flag) {
    //                 return false;
    //             }
    //         }
    //         pointerOfNums++;
    //     }
    // }
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 给定超序列的长度
        int numsLength = nums.length;
        // 节点入度
        int[] inDegree = new int[numsLength + 1];
        // 图，每个set保存了当前节点的后续节点
        Set<Integer>[] graph = new Set[numsLength + 1];
        for (int i = 1; i <= numsLength; i++) {
            graph[i] = new HashSet<>();
        }
        // 统计节点入度用于拓扑排序
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int pre = sequence[i - 1];
                int next = sequence[i];
                if (graph[pre].add(next)) {
                    inDegree[next]++;
                }
            }
        }
        // 将所有入度为0的节点入队
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= numsLength; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //
        while (!queue.isEmpty()) {
            // 如果
            if (queue.size() > 1) {
                return false;
            }

            int num = queue.poll();
            // 当前节点的后续节点
            Set<Integer> set = graph[num];
            // 每个后续节点的入度-1
            for (int next : set) {
                inDegree[next]--;
                // 入度为0则入队
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[][] sequences = new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4}, {1, 2, 3}, {4}, {5}};
        System.out.println(sequenceReconstruction.sequenceReconstruction(nums, sequences));
    }
}