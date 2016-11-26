package command;

import invoker.IHM;
import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 25/11/2016.
 */
public class InsererTexte implements Command {
    private MoteurEditionImpl m;

    public InsererTexte(MoteurEditionImpl m){
        this.m = m;
    }


    @Override
    public void execute() {
        m.insererTexte(IHM.textins);


    }
}
