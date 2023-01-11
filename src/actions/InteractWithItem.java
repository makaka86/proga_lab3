package actions;

import interfaces.IInteract;
import person.AbstractPerson;
import world.items.Item;

public class InteractWithItem extends InteractAction {
    protected final String itemNameForInteract;

    public InteractWithItem(IInteract element, String itemName) {
        super(element);
        itemNameForInteract = itemName;
    }

    @Override
    public boolean doAction(AbstractPerson actor) {
        System.out.println(actor.toString() + " применила вещь " + itemNameForInteract + " к " + element.toString());
        Item item = actor.getItem(itemNameForInteract);
        if (!element.interactWithItem(item)) {
            actor.transferItem(item);
            return false;
        }
        return true;
    }
}
