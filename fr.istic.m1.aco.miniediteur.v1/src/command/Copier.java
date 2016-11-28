package command;

import memento.Caretaker;
import memento.Memento;
import memento.MementoCopier;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Copier implements Command{
    MoteurEditionImpl m;

    public Copier(MoteurEditionImpl m){
        this.m = m;
    }

    public MementoCopier createMemento(){
        return new MementoCopier();
    }

    public void setToCaretaker(Memento m){
        Caretaker.getINSTANCE().addMemento(m);

    }

    @Override
    public void execute() {
        if(enregistrement){
            Memento mem =  createMemento();
            setToCaretaker(mem);

        }

        m.copier();

    }
}
