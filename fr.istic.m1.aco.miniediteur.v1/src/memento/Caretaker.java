package memento;

import client.Configurateur;
import command.Command;
import command.InsererTexte;
import invoker.IHM;
import reciever.MoteurEditionImpl;
import reciever.Selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static reciever.MoteurEditionImpl.enregistrement;

/**
 * Created by Safiah on 27/11/2016.
 */
public class Caretaker {

    public static Caretaker INSTANCE = new Caretaker();

    private List<Memento> listMemeto;

    private Caretaker(){
        this.listMemeto = new ArrayList<Memento>();
    }

    public static Caretaker getINSTANCE(){
        return INSTANCE;
    }

    public void addMemento(Memento m){
        listMemeto.add(m);
    }

    public Memento getMemento(int i){
        return listMemeto.get(i);
    }

   public void demarrer() {

       listMemeto.clear();
       enregistrement = true;

    }

    public void arreter(){enregistrement = false;}

    public void rejouer() {

        for (int i = 0; i < listMemeto.size(); i++) {
            if (listMemeto.get(i).getClass().getSimpleName().equals("MementoInserer")) {
                MementoInserer mem = (MementoInserer) listMemeto.get(i);
                IHM.textins = mem.getText();
                mem.getCommande().execute();
                Selection.getInstance().avancerCurseur();

            } else {
                listMemeto.get(i).getCommande().execute();
            }


        }
        listMemeto.clear();
    }






}
