package world.place.place.part;

import interfaces.IStore;
import world.items.Item;
import world.place.PlacePart;

import java.util.Hashtable;

public class Table extends PlacePart implements IStore {

    private Hashtable<String, Item> store = new Hashtable<>();

    public Table(String objectName) {
        super(objectName);
    }

    @Override
    public String getType() {
        return "table";
    }

    @Override
    public boolean interact() {
        return false;
    }

    @Override
    public boolean interactWithItem(Item object) {
        System.out.printf("Применена вещь с названием %s к %s, но ничего не произошло",
                object.getObjectName(), this.getObjectName());
        return false;
    }

    @Override
    public Item getItem(String itemName) {
        if (!store.containsKey(itemName)) {
            System.out.printf("Вещи с названием %s нет в хранилище %s", itemName, this.getObjectName());
            return null;
        }
        Item s = store.get(itemName);
        store.remove(itemName);
        return s;
    }

    @Override
    public boolean transferItem(Item item) {
        if (store.containsValue(item)) {
            System.out.printf("Вещь с названием %s уже есть в хранилище %s", item.getObjectName(), this.getObjectName());
            return false;
        }
        store.put(item.getObjectName(), item);
        return true;
    }
}
