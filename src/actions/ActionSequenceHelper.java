package actions;

import interfaces.IAction;
import person.AbstractPerson;

import java.util.ArrayDeque;
import java.util.Queue;

public class ActionSequenceHelper {

    private final AbstractPerson actor;

    private Queue<IAction> actions = new ArrayDeque<>();

    public ActionSequenceHelper(AbstractPerson actor) {
        this.actor = actor;
    }

    public ActionSequenceHelper addNextAction(IAction iAction) {
        actions.add(iAction);
        return this;
    }

    public void play() {
        for (IAction next : actions) {
            next.doAction(actor);
        }
    }
}
