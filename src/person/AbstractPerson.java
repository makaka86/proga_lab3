package person;

import interfaces.IMove;
import interfaces.IStore;
import world.MyObject;
import world.items.Item;

import java.util.Hashtable;

public abstract class AbstractPerson extends MyObject implements IStore, IMove {

    private Hashtable<String, Item> inventory = new Hashtable<>();

    protected AbstractPerson(String objectName) {
        super(objectName);
    }

    @Override
    public Item getItem(String itemName) {
        if (!inventory.containsKey(itemName)) {
            System.out.printf("Вещи с названием %s нет в хранилище %s", itemName, this.getObjectName());
            return null;
        }
        Item s = inventory.get(itemName);
        inventory.remove(itemName);
        return s;
    }

    @Override
    public boolean transferItem(Item item) {
        if (inventory.containsValue(item)) {
            System.out.printf("Вещь с названием %s уже есть в хранилище %s", item.getObjectName(), this.getObjectName());
            return false;
        }
        inventory.put(item.getObjectName(), item);
        return true;
    }

    @Override
    public void moveTo(String locName) {
        System.out.println(this.toString() + " пошел в "+locName);
    }

    @Override
    public void moveTo(MyObject myObject) {
        System.out.println(this.toString() + " подошел к "+myObject.toString());
    }

    @Override
    public String getType(){
        return "person";
    }
}
