package command;

import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 25/11/2016.
 */
public class SupprimerDel implements Command {
    MoteurEditionImpl m;
    public SupprimerDel(MoteurEditionImpl m){
        this.m = m;
    }

    @Override
    public void execute() {
        m.supprimerDel();
    }
}
