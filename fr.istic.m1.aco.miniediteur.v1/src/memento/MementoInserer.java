package memento;

import client.Configurateur;
import command.Command;
import reciever.Buffer;
import reciever.PressePapier;
import reciever.Selection;

/**
 * Created by Safiah on 27/11/2016.
 */
public class MementoInserer implements Memento{

    private Command commande;
    private StringBuffer txt;

    public MementoInserer(StringBuffer txt){

        this.commande = Configurateur.commandes.get("instxt");
        this.txt = txt;

    }

    public Command getCommande(){
        return this.commande;

    }

    public StringBuffer getText(){
        return this.txt;
    }
}
