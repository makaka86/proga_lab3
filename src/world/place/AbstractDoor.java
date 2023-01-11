package world.place;

import world.place.PlacePart;

public abstract class AbstractDoor extends PlacePart {
    protected AbstractDoor(String objectName) {
        super(objectName);
    }
    @Override
    public String getType(){
        return "door";
    }
}
