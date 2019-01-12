package treeScript.nodes;

import treeScript.iterators.PostOrderNodeIterator;
import treeScript.iterators.BreadthFirstNodeIterator;
import treeScript.iterators.NodeIterator;
import treeScript.iterators.PreOrderNodeIterator;
import treeScript.Task;

import java.util.ArrayList;

public class TaskNode extends Node {

    private Task task;

    public TaskNode(Task task) {
        this.task = task;
    }

    @Override
    public final Task getActiveTask() {
        return task;
    }

    @Override
    public ArrayList<Node> getChildren() {
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
