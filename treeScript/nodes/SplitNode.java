package treeScript.nodes;

import treeScript.iterators.BreadthFirstNodeIterator;
import treeScript.iterators.PostOrderNodeIterator;
import treeScript.iterators.NodeIterator;
import treeScript.iterators.PreOrderNodeIterator;
import treeScript.Task;

import java.util.*;

public class SplitNode extends CompositeNode {

    private ArrayList<Node> nodes;

    public SplitNode() {
        nodes = new ArrayList<>();
    }

    public SplitNode(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }


    public void addNode(Node node) {
        nodes.add(node);
    }

    public void removeNode(Node node) {
        nodes.remove(node);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public void clearNodes(Node node) {
        nodes.clear();

    }

    @Override
    public Task getActiveTask() {
        return findActiveInList(nodes);
    }

    @Override
    public ArrayList<Node> getChildren() {
        return nodes;
    }

    @Override
    public NodeIterator getBreadthFirstIterator() {
        return new BreadthFirstNodeIterator(this);
    }

    @Override
    public NodeIterator getPostOrderIterator() {
        return new PostOrderNodeIterator(this);
    }

    @Override
    public NodeIterator getPreOrderIterator() {
        return new PreOrderNodeIterator(this);
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
