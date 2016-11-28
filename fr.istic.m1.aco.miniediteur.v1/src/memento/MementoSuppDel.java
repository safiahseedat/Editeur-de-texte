package memento;

import client.Configurateur;
import command.Command;
import reciever.Buffer;
import reciever.PressePapier;
import reciever.Selection;

/**
 * Created by Safiah on 27/11/2016.
 */
public class MementoSuppDel implements Memento{

    private Command commande;

    public MementoSuppDel(){
        this.commande = Configurateur.commandes.get("suppDel");

    }

    public Command getCommande(){
        return this.commande;
    }
}
