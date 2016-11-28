package command;

import invoker.IHM;
import memento.Caretaker;
import memento.MementoCopier;
import memento.MementoInserer;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 25/11/2016.
 */
public class InsererTexte implements Command {
    private MoteurEditionImpl m;

    public InsererTexte(MoteurEditionImpl m){
        this.m = m;
    }

    public MementoInserer createMemento(){
        return new MementoInserer(new StringBuffer(IHM.textins));
    }

    public void setToCaretaker(MementoInserer m){
        Caretaker.getINSTANCE().addMemento(m);
    }


    @Override
    public void execute() {

        if(enregistrement){
            setToCaretaker(createMemento());

        }

        m.insererTexte(new StringBuffer(IHM.textins));




    }
}
