package std.test;

import std.StdOut;
import std.StdIn;
import std.Stack;

public class StackTest {
    public static void main(String[] args) {
        // Create a stack and push/pop strings as StdIn.
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
