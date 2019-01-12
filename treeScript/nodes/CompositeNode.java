package treeScript.nodes;

import treeScript.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public abstract class CompositeNode extends Node implements Comparator<Task> {

    protected Task findActiveInList(ArrayList<Node> nodes) {
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
    public int compare(Task o1, Task o2) {
        if (o1 != null && o2 != null) {
            return o2.getPriority() - o1.getPriority();
        }
        return 0;
    }
}
