package actions;

import interfaces.IAction;
import interfaces.IStore;
import person.AbstractPerson;
import world.items.Item;

public class PickUpAction implements IAction {

    private final IStore targetInventory;
    private final String itemName;

    public PickUpAction(IStore targetInventory, String itemName) {
        this.targetInventory = targetInventory;
        this.itemName = itemName;
    }

    @Override
    public boolean doAction(AbstractPerson actor) {
        Item item = targetInventory.getItem(itemName);
        if (item == null) {
            System.out.println("Не удалось найти вещь с названием" + itemName + " в хранилище " + targetInventory.toString());
            return false;
        }
        System.out.println(actor.toString() + " получил " + itemName);
        actor.transferItem(item);
        return true;
    }
}
