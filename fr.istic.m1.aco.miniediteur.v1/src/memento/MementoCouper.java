package memento;

import client.Configurateur;
import command.Command;
import reciever.Buffer;
import reciever.PressePapier;
import reciever.Selection;

/**
 * Created by Safiah on 27/11/2016.
 */
public class MementoCouper implements Memento{

    private Command commande;


    public MementoCouper(){

        this.commande = Configurateur.commandes.get("couper");

    }

    public Command getCommande(){
        return this.commande;
    }
}
