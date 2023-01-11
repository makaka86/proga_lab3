package world;

import person.AbstractPerson;
import world.place.PlacePart;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlace extends MyObject {

    private List<PlacePart> placeParts = new ArrayList<>();

    private final AbstractPerson player;

    protected AbstractPlace(String objectName, AbstractPerson player) {
        super(objectName);
        this.player = player;
    }

    public void addPartPlace(PlacePart placePart) {
        placeParts.add(placePart);
    }

    public <T extends PlacePart> List<T> getPlacePartByType(String type) {
        List<T> elems = new ArrayList<>();
        for (PlacePart placePart : placeParts) {
            if (placePart.getType().equalsIgnoreCase(type)) {
                elems.add((T) placePart);
            }
        }
        return elems;
    }
}
