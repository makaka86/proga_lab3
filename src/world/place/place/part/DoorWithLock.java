package world.place.place.part;

import world.items.Key;
import world.place.AbstractDoor;
import world.items.Item;

public class DoorWithLock extends AbstractDoor {

    private Key key;
    private boolean isOpen = false;
    private boolean isLocked = true;

    public DoorWithLock(String objectName, String keyName) {
        super(objectName);
        this.key = new Key(keyName);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public boolean interact() {
        if (!isLocked) {
            String openString = isOpen ? "закрыта" : "открыта";
            System.out.println(this.toString() + " была " + openString);
            isOpen = !isOpen;
            return true;
        }
        System.out.println(this.toString() + " на замке");
        return false;
    }

    @Override
    public boolean interactWithItem(Item object) {
        if (isLocked && object instanceof Key && this.key.equals(object)) {
            isLocked = false;
            System.out.println("К " + this.toString() + " подошел " + key.toString());
        }
        return interact();
    }
}
