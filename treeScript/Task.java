package treeScript;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public interface Task {
    int execute();
    int getPriority();
    ArrayList<BooleanSupplier> getConditions();

}
