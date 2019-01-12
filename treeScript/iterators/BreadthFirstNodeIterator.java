package treeScript.iterators;

import treeScript.Node;
import treeScript.NodeIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class BreadthFirstNodeIterator extends NodeIterator {

    LinkedList<Node> queue;
    public BreadthFirstNodeIterator(Node start) {
        this.start = start;
        queue = new LinkedList<>();
        queue.add(start);
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }

    @Override
    public Node next() {
        root = queue.poll();
        ArrayList<Node> children = root.getChildren();
        if (children != null) {
            Collections.reverse(children);
            for (Node node : children) {
                queue.add(node);
            }
        }
        return root;
    }

    @Override
    public void reset() {
        queue.clear();
        queue.add(start);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
