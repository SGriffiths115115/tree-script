package tasks;

import treeScript.Task;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Task1 implements Task {
    @Override
    public int execute() {
        System.out.println("Task1");
        return 100;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public ArrayList<BooleanSupplier> getConditions() {
        return null;
    }
}
