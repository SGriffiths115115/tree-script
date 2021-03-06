package treeScript.iterators;

import treeScript.nodes.Node;

import java.util.Iterator;

public abstract class NodeIterator implements Iterator<Node> {
    protected Node root, start;
    public abstract void reset();
}
