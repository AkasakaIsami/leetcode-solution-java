import java.util.Stack;

/**
 * @author Akasaka Isami
 * @createDate 2021/7/21 10:45 AM
 */

public class MSolution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        char tempCh = ' ';

        for (int i = 0; i < length; i++) {
            tempCh = s.charAt(i);

            if (tempCh == '(' || tempCh == '[' || tempCh == '{') {
                //left parentheses situation: directly put the parentheses into stack
                stack.push(tempCh);
            } else {
                //right parentheses situation: check whether the right parentheses match the left parentheses at the top of stack
                if (stack.empty())
                    return false;
                if (isMatched(stack.peek(), tempCh)) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }

    /**
     * check whether the two input parentheses are in the right order and match each other
     *
     * @param ch1 the first char
     * @param ch2 the second char
     * @return boolean, whether the two input parentheses are in the right order and match each other
     */
    public boolean isMatched(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')')
            return true;
        else if (ch1 == '[' && ch2 == ']')
            return true;
        else return ch1 == '{' && ch2 == '}';
    }

}
