/**
 * @author Akasaka Isami
 * @createDate 2021/7/17 7:58 PM
 */

public class MySolution {
    public int lengthOfLongestSubstring(String s) {

        StringBuilder tempStr = new StringBuilder(s.length());
        int length = s.length();
        int longestLength =  0 ;

        for (int i = 0; i < length; i++) {
            char tempCh = s.charAt(i);
            int index = getIndex(tempStr, tempCh);
            if (index != -1) {
                longestLength = Math.max(tempStr.length(), longestLength);
                tempStr.delete(0, index + 1);
            } else if (i == length - 1) {
                longestLength = Math.max(tempStr.length()+1, longestLength);
            }
            tempStr.append(tempCh);
        }

        return longestLength;
    }

    /**
     * @param str input string
     * @param ch  input char
     * @return the index of ch in str; -1 means do not exist
     */
    private int getIndex(StringBuilder str, char ch) {
        int length = str.length();
        for (int i = 0; i < length; i++)
            if (str.charAt(i) == ch)
                return i;
        return -1;
    }

}
