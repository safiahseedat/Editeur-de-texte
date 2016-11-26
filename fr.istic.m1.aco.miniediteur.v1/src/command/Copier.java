package command;

import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Copier implements Command{
    MoteurEditionImpl m;
    public Copier(MoteurEditionImpl m){
        this.m = m;
    }


    @Override
    public void execute() {
        m.copier();
    }
}
