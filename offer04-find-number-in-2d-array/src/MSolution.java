import javafx.util.Pair;

/**
 * @author Akasaka Isami
 * @createDate 2021/11/1 8:11 PM
 */

public class MSolution {
    /**
     * @param matrix n rows * m columns
     * @param target the target number
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;

        int temp;
        for (int i = 0, j = m - 1; i < n && j > -1; ) {
            temp = matrix[i][j];
            if (target == temp)
                return true;
            else if (target < temp) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int n = matrix.length, m = matrix[0].length;
//
//        int index = findIndex(0, m, target, matrix[0]);
//
//        if (target == matrix[n / 2][index]) {
//            return true;
//        } else {
//            int index2 = findIndex2(0, m, index, target, matrix);
//            if (target == matrix[index2][index])
//                return true;
//            else {
//                int index3 = findIndex(0, m, target, matrix[index2]);
//                return target == matrix[index3][index + 1];
//            }
//        }
//    }
//
//    private int findIndex(int left, int right, int target, int[] nums) {
//        int index = (left + right) / 2;
//        if (target == nums[index] || left == index)
//            return index;
//        else if (target < nums[index])
//            return findIndex(left, (left + right) / 2, target, nums);
//        else if (target > nums[index])
//            return findIndex((left + right) / 2, right, target, nums);
//        return -1;
//    }
//
//    private int findIndex2(int top, int botttom, int y, int target, int[][] nums) {
//        int index = (top + botttom) / 2;
//        if (target == nums[index][y] || top == index)
//            return index;
//        else if (target < nums[index][y])
//            return findIndex2(top, (top + botttom) / 2, y, target, nums);
//        else if (target > nums[index][y])
//            return findIndex2((top + botttom) / 2, botttom, y, target, nums);
//        return -1;
//    }
//

    public static void main(String[] args) {
        int[][] metric = {};

        int target = 0;
        MSolution solution = new MSolution();
        System.out.println(solution.findNumberIn2DArray(metric, target));
    }
}