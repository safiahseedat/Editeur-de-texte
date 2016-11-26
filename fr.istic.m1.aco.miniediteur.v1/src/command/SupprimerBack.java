package command;

import reciever.MoteurEditionImpl;

/**
 * Created by Safiah on 26/11/2016.
 */
public class SupprimerBack implements Command{
    MoteurEditionImpl m;
    public SupprimerBack(MoteurEditionImpl m){
         this.m= m;
    }

    @Override
    public void execute() {
        m.supprimerBack();
    }
}
