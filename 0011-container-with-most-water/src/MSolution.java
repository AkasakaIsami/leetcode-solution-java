/**
 * @author Akasaka Isami
 * @createDate 2021/7/22 11:42 AM
 */

public class MSolution {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int tempArea;

        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            /**
             * Since directly using two loop would cause timeout,
             * so for the second loop, we can add a conditional statement to avoid unnecessary computing
             * In this case, for those i which would never reach the value maxArea even with the longest length
             * we skip the loop
             */
            if (height[i] > maxArea / (length - i - 1))
                for (int j = i + 1; j < length; j++) {
                    tempArea = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(tempArea, maxArea);
                }
        }

        return maxArea;
    }

}
