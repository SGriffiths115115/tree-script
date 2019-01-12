package treeScript.nodes;

import treeScript.iterators.NodeIterator;
import treeScript.iterators.BreadthFirstNodeIterator;
import treeScript.iterators.PostOrderNodeIterator;
import treeScript.iterators.PreOrderNodeIterator;
import treeScript.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class ConditionalNode extends CompositeNode {

    private ArrayList<Node> trueNodes;
    private ArrayList<Node> falseNodes;
    private BooleanSupplier condition;

    public ConditionalNode(BooleanSupplier condition) {
        this.condition = condition;
        falseNodes = new ArrayList<>();
        trueNodes = new ArrayList<>();
    }

    public void addTrueNode(Node node) {
        trueNodes.add(node);
    }
    public void addFalseNode(Node node) {
        falseNodes.add(node);
    }
    public void setCondition(BooleanSupplier condition) { this.condition = condition; }
    public ArrayList<Node> getTrueNodes() { return trueNodes; }
    public ArrayList<Node> getFalseNodes() { return falseNodes; }
    public BooleanSupplier getCondition() { return condition; }
    public void clearTrueNodes(Node node) { trueNodes.clear(); }
    public void clearFalseNodes(Node node) { falseNodes.clear(); }
    public void removeNode(Node node) {
        trueNodes.remove(node);
        falseNodes.remove(node);
    }


    @Override
    public Task getActiveTask() {
        if (condition.getAsBoolean()) {
            if (trueNodes.size() > 0) {
                findActiveInList(trueNodes);
            }
        } else {
            if (falseNodes.size() > 0) {
                findActiveInList(falseNodes);
            }
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
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
