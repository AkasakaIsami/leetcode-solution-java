import java.util.Stack;

/**
 * Created on 2022/3/26 4:31 PM.
 *
 * @author akasakaisami
 */
public class CQueue {

    Stack<Integer> in;
    Stack<Integer> out;


    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.empty())
            return -1;
        int size = in.size();
        for (int i = 0; i < size; i++)
            out.push(in.pop());
        int result = out.pop();
        size = out.size();
        for (int i = 0; i < size; i++)
            in.push(out.pop());
        return result;
    }
}
