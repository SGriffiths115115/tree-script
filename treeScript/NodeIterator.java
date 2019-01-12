package treeScript;

import java.util.Iterator;

public abstract class NodeIterator implements Iterator<Node> {
    protected Node root, start;
    public abstract void reset();
}
