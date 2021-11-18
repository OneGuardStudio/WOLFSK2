package pl.ajonx.wolfsk2.objects.inventory;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.objects.Inventories;

import org.bukkit.event.Event;

public class Closed extends Effect {

    private Expression<String> name;
    private Expression<Number> slot;
    private Expression<Boolean> close;

    protected void execute(Event event) {

        String name = this.name.getSingle(event);
        Number slot = this.slot.getSingle(event);
        Boolean close = this.close.getSingle(event);
        if (name == null || slot == null || close == null) {
            return;
        }

        int i = slot.intValue();
        Inventories.get(name).setClosed(i, close);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
        this.close = (Expression<Boolean>) expressions[2];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Set Closed";
    }
}










