import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestPathValue {
    public int largestPathValue(String colors, int[][] edges) {
        // 节点数目
        int nodesNum = colors.length();
        // 邻接表
        Node[] adjList = new Node[nodesNum];
        // 各节点入度
        int[] inDegree = new int[nodesNum];

        // 创建邻接表并统计各个节点的入度
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];
            inDegree[endNode]++;
            adjList[startNode] = new Node(endNode, adjList[startNode]);
            // 「头插法」上面一行等价于下面几行操作,
            // NewNode node = new NewNode(to);
            // to.next = adjList[from];
            // adjList[from] = to;
            //
        }

        // 记录拓扑排序遇到的节点数目
        int found = 0;
        Queue<Integer> queue = new LinkedList<>();
        // f[i][j]: 截止到第 i 个节点，第 j 种颜色的数量
        int[][] f = new int[nodesNum][26];
        // 将入度为 0 的节点加入队列中
        for (int i = 0; i < nodesNum; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 开始拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            found++;
            // 将节点对应颜色 + 1
            f[cur][colors.charAt(cur) - 'a']++;

            // 遍历当前节点指向的所有节点
            for (Node next = adjList[cur]; next != null; next = next.next) {
                // 下一个节点入度 - 1
                inDegree[next.val]--;
                // 如果节点的入度为 0, 则将其加入队列 q 中
                if (inDegree[next.val] == 0) {
                    queue.offer(next.val);
                }
                // 更新 next 所有颜色数量，即f[next][c] = Math.max(f[cur][c], f[next][c])
                for (int c = 0; c < 26; c++) {
                    f[next.val][c] = Math.max(f[next.val][c], f[cur][c]);
                }
            }
        }

        // 有环，直接返回 -1
        if (found != nodesNum)
            return -1;
        int res = 0;
        for (int i = 0; i < nodesNum; i++) {
            res = Math.max(res, Arrays.stream(f[i]).max().getAsInt());
        }
        return res;
    }

    public static void main(String[] args) {
        LargestPathValue largestPathValue = new LargestPathValue();
        // String colors = "abaca";
        // int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        String colors = "ab";
        int[][] edges = new int[][]{{0, 1}, {1, 0}};
        System.out.println(largestPathValue.largestPathValue(colors, edges));
    }
}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}