package treeScript;

import java.util.Comparator;

public abstract class CompositeNode extends Node implements Comparator<Task> {

    public abstract boolean addChild(Node node);
    public abstract boolean removeChild();


    @Override
    public int compare(Task o1, Task o2) {
        if (o1 != null && o2 != null) {
            return o2.getPriority() - o1.getPriority();
        }
        return 0;
    }
}
