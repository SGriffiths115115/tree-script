import treeScript.iterators.NodeIterator;
import treeScript.TreeScript;
import treeScript.nodes.ConditionalNode;
import treeScript.nodes.SplitNode;
import treeScript.nodes.TaskNode;
import tasks.Task1;
import tasks.Task2;

public class Main {
    public static void main(String... args) {

        ConditionalNode alwaysTrue = new ConditionalNode(()-> true);
        ConditionalNode alwaysTrue2 = new ConditionalNode(()->true);
        ConditionalNode alwaysFalse = new ConditionalNode(()->false);
        alwaysTrue.addTrueNode(new TaskNode(new Task1()));
        alwaysTrue.addTrueNode(new TaskNode(new Task2()));
        alwaysFalse.addFalseNode(alwaysTrue2);
        SplitNode start = new SplitNode();
        start.addNode(alwaysTrue);
        start.addNode(alwaysFalse);
        TreeScript d = new TreeScript();
        d.setRoot(start);
        d.setStarted(true);
        //d.onLoop();
        NodeIterator iter = start.getPostOrderIterator();
       while (iter.hasNext()){
            System.out.println(iter.next());
            System.out.println(iter);
        }
        iter = start.getPreOrderIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
            System.out.println(iter);
        }
        iter = start.getBreadthFirstIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
            System.out.println(iter);
        }
    }
}
