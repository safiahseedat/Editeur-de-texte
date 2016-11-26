package command;

import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Couper implements Command {
    MoteurEditionImpl m;
    public Couper(MoteurEditionImpl m){
        this.m = m;
    }


    @Override
    public void execute() {
        m.couper();
    }
}
