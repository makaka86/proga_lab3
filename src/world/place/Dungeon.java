package world.place;

import person.AbstractPerson;
import world.AbstractPlace;

public class Dungeon extends AbstractPlace {
    public Dungeon(String objectName, AbstractPerson player) {
        super(objectName, player);
    }

    @Override
    public String getType() {
        return "place";
    }
}
