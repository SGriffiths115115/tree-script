package tasks;

import treeScript.Task;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Task2 implements Task {
    @Override
    public int execute() {
        System.out.println("Task2 boogaloo");
        return 100;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public ArrayList<BooleanSupplier> getConditions() {
        return null;
    }
}