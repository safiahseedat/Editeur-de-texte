package command;

import memento.Caretaker;
import memento.Memento;
import memento.MementoSuppDel;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 25/11/2016.
 */
public class SupprimerDel implements Command {
    MoteurEditionImpl m;
    public SupprimerDel(MoteurEditionImpl m){
        this.m = m;
    }

    public Memento createMemento(){
        return new MementoSuppDel();
    }

    public void setToCaretaker(Memento m){
        Caretaker.getINSTANCE().addMemento(m);
    }

    @Override
    public void execute() {

        if(enregistrement){
            setToCaretaker(createMemento());
        }

        m.supprimerDel();
    }
}
