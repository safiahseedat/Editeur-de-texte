package memento;

import client.Configurateur;
import command.Command;
import reciever.Buffer;
import reciever.PressePapier;
import reciever.Selection;

/**
 * Created by Safiah on 27/11/2016.
 */
public class MementoCopier implements Memento{

    private Command commande;

    public MementoCopier(){
        this.commande = Configurateur.commandes.get("copier");

    }

    public Command getCommande(){
        return this.commande;
    }
}
