/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    int[] circularQueue;
    int front = 0;
    int rear = -1;
    int length;
    int currentNum = 0;
    public MyCircularQueue(int k) {
        this.circularQueue = new int[k];
        this.length = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        } else{
            rear = (rear + 1) % length;
            circularQueue[rear] = value;
            currentNum ++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        } else{
            front = (front + 1) % length;
            currentNum--;
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            return circularQueue[front];
        }
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }else{
            return circularQueue[rear];
        }
    }
    
    public boolean isEmpty() {
        return currentNum == 0;
    }
    
    public boolean isFull() {
        return currentNum == length;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

