package world.place;

import interfaces.IInteract;
import world.MyObject;

public abstract class PlacePart extends MyObject implements IInteract {
    protected PlacePart(String objectName) {
        super(objectName);
    }
}
