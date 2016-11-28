package command;

import memento.Caretaker;
import memento.Memento;
import memento.MementoColler;
import memento.MementoCouper;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Coller implements Command {

    MoteurEditionImpl m;
    public Coller(MoteurEditionImpl m){
        this.m = m;
    }

    public MementoColler createMemento(){
       return new MementoColler();
    }

    public void setToCaretaker(Memento m){
        Caretaker.getINSTANCE().addMemento(m);
    }


    @Override
    public void execute() {

        if(enregistrement){
            setToCaretaker(createMemento());
        }

        m.coller();
    }
}
