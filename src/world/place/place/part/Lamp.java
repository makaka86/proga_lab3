package world.place.place.part;

import world.MyObject;
import world.items.Item;
import world.place.PlacePart;

public class Lamp extends PlacePart {
    public Lamp(String objectName) {
        super(objectName);
    }

    @Override
    public String getType() {
        return "lamp";
    }

    @Override
    public boolean interact() {
        return false;
    }

    @Override
    public boolean interactWithItem(Item object) {
        return false;
    }

}
