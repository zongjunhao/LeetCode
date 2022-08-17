/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] 设计有序流
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class OrderedStream {

    String[] stream;
    int ptr;

    public OrderedStream(int n) {
        stream = new String[n];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> result = new ArrayList<>();
        if (stream[ptr - 1] != null) {
            for (int i = ptr - 1; i < stream.length; i++) {
                if (stream[i] == null) {
                    ptr = i + 1;
                    break;
                }
                result.add(stream[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end

