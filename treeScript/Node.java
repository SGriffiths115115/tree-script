package treeScript;

import java.util.ArrayList;

public abstract class Node {

    public abstract Task getActiveTask();
    public abstract ArrayList<Node> getChildren();
    public abstract NodeIterator getBreadthFirstIterator();
    public abstract NodeIterator getPostOrderIterator();
    public abstract NodeIterator getPreOrderIterator();

    @Override
    public String toString(){
        return "Node subclass";
    }
}
