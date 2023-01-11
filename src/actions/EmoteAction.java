package actions;

import enums.Emote;
import interfaces.IAction;
import interfaces.IFeature;
import person.AbstractPerson;

public class EmoteAction implements IAction {

    private final IFeature emote;

    public EmoteAction(IFeature emote) {
        this.emote = emote;
    }

    @Override
    public boolean doAction(AbstractPerson actor) {
        System.out.println(actor.toString() + " применил эмоцию " + emote.toString());
        actor.applyFeature(emote);
        return true;
    }
}
