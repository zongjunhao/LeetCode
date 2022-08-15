/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class MySqrt {
    // public int mySqrt(int x) {
    //     if (x == 0) {
    //         return 0;
    //     }
    //     int left = 1;
    //     int right = x;
    //     int mid, sqrt;
    //     while (left <= right) {
    //         mid = left + (right - left) / 2;
    //         sqrt = x / mid;
    //         if (sqrt == mid) {
    //             return mid;
    //         } else if (mid > sqrt) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return right;
    // }
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(16));
    }
}
// @lc code=end

