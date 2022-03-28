/**
 * Created on 2022/3/26 6:59 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int[][] imageSmoother(int[][] img) {
        // 定义矩阵的宽n与高m
        int m = img.length, n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                // 如果没有越界，直接计算
                if (i > 0 && j > 0 && i < m - 1 && j < n - 1) {
                    int sum = img[i - 1][j - 1] + img[i - 1][j] + img[i - 1][j + 1]
                            + img[i][j - 1] + img[i][j] + img[i][j + 1]
                            + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1];
                    double average = sum / 9;
                    result[i][j] = (int) Math.floor(average);
                }
                else {
                    // 如果存在越界，依次累加，越界值直接跳过
                    int sum = 0, num = 0;
                    for (int x = i - 1; x <= i + 1; x++)
                        for (int y = j - 1; y <= j + 1; y++)
                            if (x >= 0 && y >= 0 && x < m && y < n) {
                                num++;
                                sum += img[x][y];
                            }
                    result[i][j] = (int) Math.floor(sum / num);
                }
            }

        return result;
    }

}
