package client;

import command.*;
import invoker.IHM;
import javafx.application.Application;
import reciever.MoteurEditionImpl;

import java.util.HashMap;

/**
 * Created by Safiah on 25/11/2016.
 */
public class Configurateur {
    private static MoteurEditionImpl m = new MoteurEditionImpl();

    public static MoteurEditionImpl getMoteur(){
        return m;
    }

    public static HashMap<String, Command> commandes = new HashMap();




    public static void main(String[] args) {
        Coller coller = new Coller(m);
        Copier copier = new Copier(m);
        Couper couper = new Couper(m);
        InsererTexte instxt = new InsererTexte(m);
        SupprimerDel supDel = new SupprimerDel(m);
        SupprimerBack supBack = new SupprimerBack(m);

        commandes.put("coller",coller);
        commandes.put("copier", copier);
        commandes.put("couper", couper);
        commandes.put("instxt", instxt);
        commandes.put("delete", supDel);
        commandes.put("backspace", supBack);




        Application.launch(IHM.class,args);
    }
}

