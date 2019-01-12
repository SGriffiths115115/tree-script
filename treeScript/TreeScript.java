package treeScript;

import org.dreambot.api.script.AbstractScript;
import treeScript.nodes.Node;

public class TreeScript extends AbstractScript {
    private Node root;
    private int defaultSleep = 200;
    private boolean started = false;

    @Override
    public final int onLoop() {
        if (started) {
            Task active = root.getActiveTask();
            if (active != null) {
                return active.execute();
            }
        }
        return defaultSleep;
    }

    public boolean isStarted() { return started; }
    public void setStarted(boolean started) {
        this.started = started;
    }
    public void setRoot(Node root) { this.root = root; }
    public Node getRoot() { return root; }
    public int getDefaultSleep() { return defaultSleep; }
    public void setDefaultSleep(int defaultSleep) { this.defaultSleep = defaultSleep; }
}
