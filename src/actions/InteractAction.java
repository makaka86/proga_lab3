package actions;

import interfaces.IAction;
import interfaces.IInteract;
import person.AbstractPerson;

public class InteractAction implements IAction {

    protected final IInteract element;
    public InteractAction(IInteract element) {
        this.element = element;
    }

    @Override
    public boolean doAction(AbstractPerson actor) {
        System.out.println(actor.toString() + " взаимодействует с " + element.toString());
        return element.interact();
    }
}
