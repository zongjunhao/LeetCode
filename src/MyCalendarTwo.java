import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    // ArrayList<Integer> startList;
    // ArrayList<Integer> endList;
    //
    // public MyCalendarTwo() {
    //     this.startList = new ArrayList<>();
    //     this.endList = new ArrayList<>();
    // }
    //
    // public boolean book(int start, int end) {
    //     // 与该时间段重叠的预定列表
    //     ArrayList<Integer> overlapIndexList = new ArrayList<>();
    //     // 遍历预定列表，统计输入时间段内已有的预定数目
    //     for (int i = 0; i < startList.size(); i++) {
    //         if (overlap(start, end, startList.get(i), endList.get(i))) {
    //             if (!addOverlapIndexList(overlapIndexList, i)) {
    //                 return false;
    //             }
    //         }
    //     }
    //
    //     // 预定成功
    //     startList.add(start);
    //     endList.add(end);
    //     return true;
    // }
    //
    // /**
    //  * 记录与该时间段重叠的预定列表，若该列表有两个预定重叠，则再加入预定会产生三重预定
    //  *
    //  * @param overlapIndexList 原预定索引列表
    //  * @param newIndex         新预订索引
    //  * @return 是否添加成功
    //  */
    // private boolean addOverlapIndexList(ArrayList<Integer> overlapIndexList, int newIndex) {
    //     for (int index : overlapIndexList) {
    //         if (overlap(startList.get(index), endList.get(index), startList.get(newIndex), endList.get(newIndex))) {
    //             return false;
    //         }
    //     }
    //     overlapIndexList.add(newIndex);
    //     return true;
    // }
    //
    // /**
    //  * 判断两个预定是否重叠
    //  *
    //  * @param start1 预定1开始时间
    //  * @param end1   预定1结束时间
    //  * @param start2 预定2开始时间
    //  * @param end2   预定2结束时间
    //  * @return 是否重叠
    //  */
    // private boolean overlap(int start1, int end1, int start2, int end2) {
    //     return end1 > start2 && end2 > start1;
    // }
    List<int[]> bookList;

    public MyCalendarTwo() {
        this.bookList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] newBook = new int[]{start, end};
        // 与该时间段重叠的预定列表
        List<Integer> overlapIndexList = new ArrayList<>();
        // 遍历预定列表，统计输入时间段内已有的预定数目
        for (int i = 0; i < bookList.size(); i++) {
            if (overlap(newBook, bookList.get(i))) {
                if (!addOverlapIndexList(overlapIndexList, i)) {
                    return false;
                }
            }
        }

        // 预定成功
        bookList.add(new int[]{start, end});
        return true;
    }

    /**
     * 记录与该时间段重叠的预定列表，若该列表有两个预定重叠，则再加入预定会产生三重预定
     *
     * @param overlapIndexList 原预定索引列表
     * @param newIndex         新预订索引
     * @return 是否添加成功
     */
    private boolean addOverlapIndexList(List<Integer> overlapIndexList, int newIndex) {
        for (int index : overlapIndexList) {
            if (overlap(bookList.get(index), bookList.get(newIndex))) {
                return false;
            }
        }
        overlapIndexList.add(newIndex);
        return true;
    }

    /**
     * 判断两个预定是否重叠
     *
     * @param book1 预定1
     * @param book2 预定2
     * @return 是否重叠
     */
    private boolean overlap(int[] book1, int[] book2) {
        return book1[1] > book2[0] && book2[1] > book1[0];
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}
