package interfaces;

import world.items.Item;

public interface IStore {
    Item getItem(String itemName);

    boolean transferItem(Item item);
}
