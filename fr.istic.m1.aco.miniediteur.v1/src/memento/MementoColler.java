package memento;

import client.Configurateur;
import command.Coller;
import command.Command;
import reciever.Buffer;
import reciever.PressePapier;
import reciever.Selection;

/**
 * Created by Safiah on 27/11/2016.
 */
public class MementoColler implements Memento{

    private Command commande;


    public MementoColler(){

        commande = Configurateur.commandes.get("coller");

    }

    public Command getCommande(){
        return this.commande;
    }
}
