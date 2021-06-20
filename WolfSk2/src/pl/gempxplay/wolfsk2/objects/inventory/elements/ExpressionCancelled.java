package pl.gempxplay.wolfsk2.objects.inventory.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import pl.gempxplay.wolfsk2.objects.inventory.Inventories;

import org.bukkit.event.Event;

public class ExpressionCancelled extends SimpleExpression<Boolean> {

    private Expression<String> name;
    private Expression<Number> slot;

    protected Boolean[] get(Event event) {

        String name = this.name.getSingle(event);
        Number slot = this.slot.getSingle(event);
        if (name == null) {
            return null;
        }

        int i = slot.intValue();
        return new Boolean[]{ Inventories.get(name).getCancelled(i) };

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    public String toString(Event event, boolean b) {
        return "[Inventory] Get Cancelled";
    }
}


	


