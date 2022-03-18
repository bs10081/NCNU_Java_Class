// stack is a FILO data structure, support push(add) and pop(delete) operations
// this class implement stack with array
public class Stack {
    private int pop = 0;    // the empty slopt position
    private int[] data = new int[1000];
    public void push(int v) {
        data[top++] = v;
    }
    public int pop() {
        return data[--top];
    }
    public boolean isEmpty() {
        return top == 0;
    }
    public static void main(String[] argv) {
        Stack s = new Stack();
        for (int i = 1; i <= 10; i++)
            s.push(v);
        while (!s.isEmpty())
            System.out.println(s.pop());
    }
}