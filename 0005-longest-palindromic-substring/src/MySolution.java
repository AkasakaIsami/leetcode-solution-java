import java.util.Stack;

/**
 * @author Akasaka Isami
 * @createDate 2021/7/19 2:33 PM
 */

public class MySolution {
    private static final int ODD = 0;
    private static final int EVEN = 1;

    public String longestPalindrome(String s) {
        Stack<Character> stack = new Stack<>();

        //Init data
        int length = s.length();
        String longestStr = "";
        String tempStr = "";
        char tempChar;

        //Iterate over the input string
        for (int i = 0; i < length; i++) {
            tempChar = s.charAt(i);

            if (stack.empty()) {
                //First loop, deal with empty stack situation
                stack.push(tempChar);
                longestStr = tempChar + "";
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                //Second case, for the palindromic string with an even length
                tempStr = check(stack, s, i, EVEN);
                longestStr = longestStr.length() > tempStr.length() ? longestStr : tempStr;
            }

            if (i < length - 1 && stack.peek() == s.charAt(i + 1)) {
                //First case, for the palindromic string with an odd length
                tempStr = check(stack, s, i, ODD);
                longestStr = longestStr.length() > tempStr.length() ? longestStr : tempStr;
            }

            stack.push(tempChar);
            //Common case, for those unordered chars, directly push them into the stack :)
        }
        return longestStr;
    }


    private String check(Stack<Character> stack, String str, int index, int flag) {
        StringBuilder result = new StringBuilder();
        char tempChar;
        int length = flag == EVEN ? 0 : 1;
        index = flag == EVEN ? index : index + 1;

        while (true) {
            if (stack.empty() || index == str.length() || stack.peek() != str.charAt(index)) {
                //First of all, bounds checking
                int size =  length / 2 ;
                for (int i = 0; i < length; i++) {
                    tempChar = str.charAt(index - length + i);
                    if (i < size)
                        stack.push(tempChar);
                    result.append(tempChar);
                }
                break;
            } else if (stack.peek() == str.charAt(index)) {
                stack.pop();
                index++;
                length += 2;
            }
        }
        return result.toString();
    }

}
