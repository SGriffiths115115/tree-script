import org.dreambot.api.methods.MethodContext;

import java.util.function.BooleanSupplier;

public class ConditionsProvider {
    private MethodContext context;

    public ConditionsProvider(MethodContext context) {
        this.context = context;
    }

    public static BooleanSupplier alwaysTrue = () -> true;

    public BooleanSupplier isInventoryFull = () -> context.getInventory().isFull();
}
