package command;

import memento.Caretaker;
import memento.Memento;
import memento.MementoSuppBack;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 26/11/2016.
 */
public class SupprimerBack implements Command{
    MoteurEditionImpl m;
    public SupprimerBack(MoteurEditionImpl m){
         this.m= m;
    }

    public MementoSuppBack createMemento(){
        return new MementoSuppBack();
    }

    public void setToCaretaker(Memento m){
        Caretaker.getINSTANCE().addMemento(m);
    }


    @Override
    public void execute() {
        if(enregistrement){
            setToCaretaker(createMemento());
        }

        m.supprimerBack();
    }
}
