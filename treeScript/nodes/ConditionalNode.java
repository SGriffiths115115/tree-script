package treeScript.nodes;

import treeScript.CompositeNode;
import treeScript.Node;
import treeScript.NodeIterator;
import treeScript.iterators.BreadthFirstNodeIterator;
import treeScript.iterators.PostOrderNodeIterator;
import treeScript.iterators.PreOrderNodeIterator;
import treeScript.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class ConditionalNode extends CompositeNode {

    /********** Fields ************/
    private ArrayList<Node> trueNodes = new ArrayList<>();
    private ArrayList<Node> falseNodes = new ArrayList<>();
    private BooleanSupplier condition;

    /********** Constructor ************/
    public ConditionalNode(BooleanSupplier condition) {
        this.condition = condition;
    }

    public void setTrueNode(Node node) {
        trueNodes.add(node);
    }
    public void setFalseNode(Node node) {
        falseNodes.add(node);
    }
    public void setCondition(BooleanSupplier condition) { this.condition = condition; }
    public ArrayList<Node> getTrueNodes() { return trueNodes; }
    public ArrayList<Node> getFalseNodes() { return falseNodes; }
    public BooleanSupplier getCondition() { return condition; }

    @Override
    public Task getActiveTask() {
        if (condition.getAsBoolean()) {
            if (trueNodes != null) {
                Optional<Task> returnTask = trueNodes.stream()
                        .map(node -> node.getActiveTask())
                        .filter(Objects::nonNull)
                        .sorted(this)
                        .findFirst();
                if (returnTask.isPresent()) {
                    return returnTask.get();
                }
                return null;
            }
        }
        else if (falseNodes != null) {
            Optional<Task> returnTask = falseNodes.stream()
                    .map(node -> node.getActiveTask())
                    .filter(Objects::nonNull)
                    .sorted(this)
                    .findFirst();
            if (returnTask.isPresent()) {
                return returnTask.get();
            }
            return null;
        }
        return null;
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
    public ArrayList<Node> getChildren() {
        ArrayList<Node> returnList = new ArrayList<>();
        returnList.addAll(trueNodes);
        returnList.addAll(falseNodes);
        return returnList;
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
