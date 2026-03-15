import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 1. 遍历一遍，只保留递增序列 A，把破坏顺序的丢到临时列表 B
 * 2. 对 B 递归执行同样排序
 * 3. 合并有序的 A 和 递归排好的 B
 * 4. 递归直到没有逆序元素
 */
public class SplitMergeSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(8);
        arr.add(16);
        arr.add(7);
        arr.add(2);
        arr.add(19);
        arr.add(4);
        arr.add(18);
        arr.add(79);
        arr.add(25);
        arr.add(49);
        arr.add(33);
        arr.add(27);
        arr.add(18);

        System.out.println("排序前：" + arr);
        List<Integer> sorted = yourSort(arr);
        System.out.println("排序后：" + sorted);
    }


    public static List<Integer> yourSort(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) {
            return new ArrayList<>(arr);
        }

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int num : arr) {
            if (A.isEmpty()) {
                A.add(num);
            } else {
                if (num < A.get(A.size() - 1)) {
                    B.add(num);
                } else {
                    A.add(num);
                }
            }
        }

        List<Integer> sortedB = yourSort(B);

        return mergeTwoSorted(A, sortedB);
    }

    private static List<Integer> mergeTwoSorted(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }

        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));

        return res;
    }
}
