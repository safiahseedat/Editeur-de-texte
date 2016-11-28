package command;

import memento.Caretaker;
import memento.Memento;
import memento.MementoCouper;
import reciever.MoteurEditionImpl;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Couper implements Command {
    MoteurEditionImpl m;

    public Couper(MoteurEditionImpl m){
        this.m = m;
    }

   public MementoCouper createMemento(){
       return new MementoCouper();
   }

   public void setToCaretaker(MementoCouper m){
        Caretaker.getINSTANCE().addMemento(m);
    }


    @Override
    public void execute() {

        if(enregistrement){
            setToCaretaker(createMemento());
        }


        m.couper();
    }
}
