/**
 * Created on 2022/4/28 7:41 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int[] spiralOrder(int[][] matrix) {
        int height = matrix.length, width = height != 0 ? matrix[0].length : 0;
        int[] result = new int[width * height];

        // 定义当前迭代的四角坐标
        // left top, left bottom, right top, right bottom
        int[] lt = new int[]{0, 0};
        int[] lb = new int[]{height - 1, 0};
        int[] rt = new int[]{0, width - 1};
        int[] rb = new int[]{height - 1, width - 1};

        int index = 0;
        int i = 0, j = 0;
        // 迭代终止条件，lb和lt（等价于rb和rt）或 lt和rt（等价于lb和rb）碰到一起
        while (lb[0] >= lt[0] && lt[1] <= rt[1]) {

            // 横着向右打印
            for (i = lt[0], j = lt[1]; j <= rt[1]; j++) {
                result[index] = matrix[i][j];
                index++;
            }

            // 竖着向下打印
            for (j = rt[1], i++; i <= rb[0]; i++) {
                result[index] = matrix[i][j];
                index++;
            }

            if (rt[0] != rb[0] && rb[1] != lb[1]) {
                // 横着向左打印
                for (i = rb[0], j--; j >= lb[1]; j--) {
                    result[index] = matrix[i][j];
                    index++;
                }

                // 竖着向上打印
                for (j = lb[1], i--; i >= lt[0] + 1; i--) {
                    result[index] = matrix[i][j];
                    index++;
                }
            }


            lt[0]++;
            lt[1]++;

            rt[0]++;
            rt[1]--;

            rb[0]--;
            rb[1]--;

            lb[0]--;
            lb[1]++;
        }

        return result;
    }

}
