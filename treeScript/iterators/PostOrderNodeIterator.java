package treeScript.iterators;

import treeScript.nodes.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderNodeIterator extends NodeIterator {
    private Node returnVal = null;
    private ArrayList<Node> traversedList;
    protected Stack<Node> stack;

    public PostOrderNodeIterator(Node start) {
        this.start = start;
        root = start;
        stack = new Stack<>();
        traversedList = new ArrayList<>();
        buildStack();
    }

    @Override
    public boolean hasNext() {
        return stack.size() > 0;
    }

    @Override
    public Node next() {
        buildStack();
        root = stack.pop();
        ArrayList<Node> children = root.getChildren();
        if (isLeaf(root)) {
            return returnNode();
        }
        if(stack.size() > 0 && children.contains(stack.peek())) {
            Node temp = stack.pop();
            stack.push(root);
            root = temp;
            return next();
        } else {
            return returnNode();
        }
    }

    private void descendLeft() {
        ArrayList<Node> children = root.getChildren();
        int nodesAdded = 0;
        if (children != null) {
            Collections.reverse(children);
            for (Node child : children) {
                if(!traversedList.contains(child)) {
                    stack.push(child);
                    nodesAdded++;
                }
            }
            if (nodesAdded > 0) {
                Node temp = stack.pop();
                stack.push(root);
                root = temp;
            } else {
                stack.push(root);
                root = null;
            }
        } else {
            stack.push(root);
            root = null;
        }
    }

    private Node returnNode() {
        returnVal = root;
        root = null;
        traversedList.add(returnVal);
        return returnVal;
    }

    private void buildStack() {
        while (root != null) {
            descendLeft();
        }
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public boolean isLeaf(Node node) {
        if (node.getChildren() == null)
            return true;
        return false;
    }

    @Override
    public void reset() {
        stack.clear();
        traversedList.clear();
        root = start;
        buildStack();
    }
}