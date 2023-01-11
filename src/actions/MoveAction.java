package actions;

import interfaces.IAction;
import person.AbstractPerson;
import world.MyObject;

public class MoveAction implements IAction {
    private final String location;
    private final MyObject object;

    public MoveAction(MyObject object) {
        this.location = null;
        this.object = object;
    }

    public MoveAction(String location) {
        this.location = location;
        this.object = null;
    }

    @Override
    public boolean doAction(AbstractPerson actor) {
        if (location == null) {
            actor.moveTo(object);
        } else {
            actor.moveTo(location);
        }
        return true;
    }
}
