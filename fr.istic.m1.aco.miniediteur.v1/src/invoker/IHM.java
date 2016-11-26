package invoker;/**
 * Created by Safiah on 25/11/2016.
 */

import client.Configurateur;
import command.Coller;
import command.Command;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import reciever.MoteurEditionImpl;
import reciever.Selection;

public class IHM extends Application {

    public static StringBuffer textins;

    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp);
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button copier = new Button("Copier");
        copier.setPrefSize(100, 20);
        Button couper = new Button("Couper");
        couper.setPrefSize(100, 20);
        Button coller = new Button("Coller");
        coller.setPrefSize(100, 20);


        hbox.getChildren().addAll(copier, couper, coller);

        TextArea textArea = new TextArea();

        copier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Configurateur.getMoteur().selectionner(textArea.getSelection().getStart(), textArea.getSelection().getEnd());
                Configurateur.commandes.get("copier").execute();
                textArea.setText(Configurateur.getMoteur().buffer.getTexte().toString());
            }
        });
        coller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Configurateur.getMoteur().selectionner(textArea.getSelection().getStart(), textArea.getSelection().getEnd());
                Configurateur.commandes.get("coller").execute();
                textArea.setText(Configurateur.getMoteur().buffer.getTexte().toString());

            }
        });

        couper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Configurateur.getMoteur().selectionner(textArea.getSelection().getStart(), textArea.getSelection().getEnd());
                Configurateur.commandes.get("couper").execute();
                textArea.setText(Configurateur.getMoteur().buffer.getTexte().toString());
            }
        });


        bp.setTop(hbox);



        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Configurateur.getMoteur().selectionner(textArea.getSelection().getStart(), textArea.getSelection().getEnd());
                if(event.getCode().equals(KeyCode.ENTER)){
                    textins = new StringBuffer("/n");
                    Configurateur.commandes.get("instxt").execute();
                }else if(event.getCode().equals(KeyCode.BACK_SPACE)){
                    if(textArea.getSelection().getEnd() != 0){
                        Configurateur.commandes.get("backspace").execute();
                    }
                }else if(event.getCode().equals(KeyCode.DELETE)){
                    if(textArea.getSelection().getStart() != textArea.getLength()) {
                        Configurateur.commandes.get("delete").execute();
                    }
                }else if(event.getCode().equals(KeyCode.SPACE)){
                    textins = new StringBuffer(" ");
                    Configurateur.commandes.get("instxt").execute();
                }else if (event.getCode().isLetterKey() || event.getCode().isDigitKey()){
                    textins = new StringBuffer(event.getText());
                    Configurateur.commandes.get("instxt").execute();
                    Configurateur.getMoteur().buffer.lire();

                }

            }



        });


        //bp.getChildren().add(textArea);
        bp.setCenter(textArea);



        stage.setScene(scene);
        stage.show();
    }
}
