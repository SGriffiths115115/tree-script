package treeScript.iterators;

import treeScript.nodes.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PreOrderNodeIterator extends NodeIterator {

    protected Stack<Node> stack;

    public PreOrderNodeIterator(Node start) {
        this.start = start;
        stack = new Stack<>();
        stack.push(start);
    }

    @Override
    public boolean hasNext() {
        return stack.size() > 0;
    }

    @Override
    public Node next() {
        root = stack.pop();
        ArrayList<Node> children = root.getChildren();
        if (children != null) {
            Collections.reverse(children);
            for (Node node : children) {
                stack.push(node);
            }
        }
        return root;
    }

    @Override
    public void reset() {
        stack.clear();
        stack.push(start);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
