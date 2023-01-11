package actions;

import interfaces.IAction;
import person.AbstractPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomAction implements IAction {

    private final IAction targetAction;
    private final List<IAction> noiseActions;

    public RandomAction(IAction targetAction, IAction... actions) {
        this.targetAction = targetAction;
        this.noiseActions = Arrays.asList(actions);

    }

    private static int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }


    @Override
    public boolean doAction(AbstractPerson actor) {
        while (true) {
            //Пуассон, 2acc
            double lam = (noiseActions.size() + 1.0) / 2;
            List<IAction> rnd = new ArrayList<>(noiseActions);
            rnd.add(rnd.size() / 2, targetAction);
            int poisson = getPoisson(lam);
            IAction iAction = rnd.get(Math.min(rnd.size() - 1, poisson));
            boolean b = iAction.doAction(actor);
            if (iAction.equals(targetAction)) {
                return b;
            }
        }
    }
}
