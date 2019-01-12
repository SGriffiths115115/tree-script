package treeScript.nodes;

import treeScript.CompositeNode;
import treeScript.iterators.BreadthFirstNodeIterator;
import treeScript.iterators.PostOrderNodeIterator;
import treeScript.Node;
import treeScript.NodeIterator;
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
        Optional<Task> returnTask = nodes.stream()
                .map(node -> node.getActiveTask())
                .filter(Objects::nonNull)
                .sorted(this)
                .findFirst();
        if (returnTask.isPresent()) {
            return returnTask.get();
        }
        return null;
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
    public boolean addChild(Node node) {
        return false;
    }

    @Override
    public boolean removeChild() {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
