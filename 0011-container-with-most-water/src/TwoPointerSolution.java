/**
 * @author Akasaka Isami
 * @createDate 2021/7/22 12:43 PM
 */

public class TwoPointerSolution {
    public int maxArea(int[] height) {
        int tempMax = 0;
        int maxArea = tempMax;

        int lp = 0, rp = height.length - 1;
        while (lp != rp) {
            tempMax = (rp - lp) * Math.min(height[lp], height[rp]);
            maxArea = Math.max(tempMax, maxArea);
            if (height[lp] < height[rp])
                lp++;
            else rp--;
        }
        return maxArea;
    }

}
