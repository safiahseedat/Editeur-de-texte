package command;

import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Coller implements Command {

    MoteurEditionImpl m;
    public Coller(MoteurEditionImpl m){
        this.m = m;
    }

    @Override
    public void execute() {
        m.coller();
    }
}
